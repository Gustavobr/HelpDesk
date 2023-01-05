package br.com.qintess.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.qintess.DTO.TecnicoDTO;
import br.com.qintess.domain.Tecnico;
import br.com.qintess.service.TecnicoService;
import enums.Perfil;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

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

	static List<TecnicoDTO> listDTO = new ArrayList<>();

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
