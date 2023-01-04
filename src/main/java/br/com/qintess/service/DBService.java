package br.com.qintess.service;

import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qintess.domain.Chamado;
import br.com.qintess.domain.Cliente;
import br.com.qintess.domain.Tecnico;
import br.com.qintess.repositories.ChamadoRepository;
import br.com.qintess.repositories.ClienteRepository;
import br.com.qintess.repositories.TecnicoRepository;
import enums.Perfil;
import enums.Prioridade;

@Service
public class DBService {

	@Autowired
	private ChamadoRepository chamadoRepo;

	@Autowired
	private TecnicoRepository tecnicoRepo;

	@Autowired
	private ClienteRepository clienteRepo;

	public void initDB() {
		byte[] pass = "root".getBytes();
		Tecnico tec1 = new Tecnico(null, "Roger Pereira", "989381003467", "rogerpereira@gmail.com",
				Base64.encodeBase64String(pass).toString(), 2);
		tec1.addPerfil(Perfil.TECNICO);

		byte[] pass1 = "mestre".getBytes();

		Cliente cli1 = new Cliente(null, "linus Torvalds", "98946588765", "linus@outlook.com",
				Base64.encodeBase64String(pass1));
		cli1.addPerfil(Perfil.CLIENTE);

		Chamado c1 = new Chamado(null, Prioridade.BAIXA, enums.Status.ABERTO, "Troca de HD", "HD SATA NOVO", tec1,
				cli1);
		Chamado c2 = new Chamado(null, Prioridade.BAIXA, enums.Status.ABERTO, "Troca de HD", "HD SATA NOVO", tec1,
				cli1);

		/* Adding the values on tables */

		tecnicoRepo.saveAll(Arrays.asList(tec1));
		clienteRepo.saveAll(Arrays.asList(cli1));
		chamadoRepo.saveAll(Arrays.asList(c1,c2));
	}

}
