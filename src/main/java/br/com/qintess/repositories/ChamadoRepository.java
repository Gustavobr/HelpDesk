package br.com.qintess.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.qintess.domain.Chamado;

@Repository
@Qualifier(value = "chamadoRepo")
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
