package br.com.qintess.resources;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.qintess.DTO.TecnicoDTO;
import br.com.qintess.domain.Tecnico;
import br.com.qintess.service.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

	@Autowired

	private TecnicoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@org.springframework.transaction.annotation.Transactional
	@CacheEvict(allEntries = true)
	public ResponseEntity<TecnicoDTO> findById(@PathVariable(required = true, value = "id") Integer id)
			throws Exception, IOException {
		try {
			if (service.findById(id).isPresent()) {
				Tecnico obj = service.findById(id).get();
				return ResponseEntity.ok().body(new TecnicoDTO(obj));
			}
		} catch (Exception ex) {

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
