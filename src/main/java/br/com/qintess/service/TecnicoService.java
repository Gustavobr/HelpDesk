package br.com.qintess.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qintess.domain.Tecnico;
import br.com.qintess.repositories.TecnicoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TecnicoService {

	@Autowired

	private TecnicoRepository tecnicoRepo;

	public Tecnico findById(Integer id) {
		try {
			return tecnicoRepo.findById(id)
					.orElseThrow(() -> new ObjectNotFoundException("Técnico não encontrado. ID:" + " " + id));
		} catch (Exception ex) {
			throw new EntityNotFoundException("Tecnico não encontrado!");
		}

	}

}
