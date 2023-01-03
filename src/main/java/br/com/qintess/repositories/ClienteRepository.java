package br.com.qintess.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.qintess.domain.Cliente;

@Repository
@Qualifier(value = "clienteRepo")
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
