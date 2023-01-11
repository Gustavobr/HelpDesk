package br.com.qintess.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.qintess.DTO.TecnicoDTO;
import br.com.qintess.domain.Pessoa;
import br.com.qintess.domain.Tecnico;
import br.com.qintess.repositories.PessoaRepository;
import br.com.qintess.repositories.TecnicoRepository;
import br.com.qintess.resources.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired

	private TecnicoRepository tecnicoRepo;

	@Autowired

	private PessoaRepository pessoaRepo;

	public Tecnico findById(Integer id) {
		try {
			return tecnicoRepo.findById(id)
					.orElseThrow(() -> new ObjectNotFoundException("Técnico não encontrado. ID:" + " " + id));
		} catch (Exception ex) {
			throw new EntityNotFoundException("Tecnico não encontrado!");
		}

	}

	public Tecnico create(TecnicoDTO tecDTO) throws IOException {
		tecDTO.setId(null);
		validaCpfPorEmail(tecDTO);
		Tecnico newObj = new Tecnico(tecDTO);
		return tecnicoRepo.save(newObj);
	}

	private void validaCpfPorEmail(TecnicoDTO tecDTO) {
		Optional<Pessoa> obj = pessoaRepo.findByCpf(tecDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != tecDTO.getId()) {
			throw new DataIntegrityViolationException("Cpf já existe");
		}
		obj = pessoaRepo.findByEmail(tecDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != tecDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema.");
		}
	}

	public List<Tecnico> findAll() {
		try {
			List<Tecnico> list = tecnicoRepo.findAll();
			return list;
		} catch (Exception ex) {

		}
		return null;
	}

	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) throws ObjectNotFoundException {
		Tecnico tec = tecnicoRepo.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Técnico não encontrado."));
		if (tec != null) {
			return tec;
		}
		return null;
	}

	public Tecnico delete(Integer id) {
		if (id != null) {
			Tecnico tec = tecnicoRepo.findById(id)
					.orElseThrow(() -> new ObjectNotFoundException("Técnico não encontrado."));
			return tec;
		}
		return null;

	}

}
