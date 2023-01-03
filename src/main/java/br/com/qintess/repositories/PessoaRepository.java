package br.com.qintess.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.qintess.domain.Pessoa;

@Repository
@Qualifier(value = "pessoaRepo")
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
