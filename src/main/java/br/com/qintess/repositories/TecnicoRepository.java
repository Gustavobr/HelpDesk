package br.com.qintess.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.qintess.domain.Tecnico;

@Repository
@Qualifier(value = "tecnicoRepo")
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
