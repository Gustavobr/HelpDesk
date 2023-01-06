package br.com.qintess.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.qintess.domain.Pessoa;

@Repository
@Qualifier(value = "pessoaRepo")
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	@Query(name="findByCpf", value="")
	Optional<Pessoa> findByCpf(String cpf);
	
	
	Optional<Pessoa> findByEmail(String email);
}
