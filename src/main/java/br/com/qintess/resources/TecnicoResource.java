package br.com.qintess.resources;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.qintess.DTO.TecnicoDTO;
import br.com.qintess.domain.Tecnico;
import br.com.qintess.service.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

	private static List<TecnicoDTO> listDTO = new ArrayList<>();
	@Autowired(required = true)
	private TecnicoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	@CacheEvict(allEntries = true)
	public ResponseEntity<TecnicoDTO> findById(@PathVariable(required = true, value = "id") Integer id)
			throws Exception, IOException {
		try {

			Tecnico obj = service.findById(id);
			return ResponseEntity.ok().body(new TecnicoDTO(obj));

		} catch (Exception ex) {

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PostMapping
	public ResponseEntity<TecnicoDTO> create(@RequestBody TecnicoDTO tecDTO) throws IOException, URISyntaxException {
		Tecnico tecnico = service.create(tecDTO);
		URI uriObj = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tecnico.getId())
				.toUri();
		return ResponseEntity.created(uriObj).build();

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CacheEvict(allEntries = true)
	@Transactional(readOnly = true)
	public List<TecnicoDTO> findAll() throws IOException {
		List<Tecnico> list = service.findAll();
		for (Tecnico tec : list) {

			tec.setCodigo(2);
			Set<Integer> perfis = new HashSet<>();
			perfis.add(tec.getCodigo());
			// tec.addPerfil(Perfil.to_ENUM(tec.getCodigo()));
			// tec.setPerfis();
			// tec.setPerfis(null);
			TecnicoDTO tecDTO = new TecnicoDTO(tec);
			listDTO.add(tecDTO);
		}
		// list.stream().map(tecnico -> new TecnicoDTO(tecnico));
		return listDTO;
		/// return ResponseEntity.ok().body(listDTO);

	}

}
