package br.com.qintess;

import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.qintess.domain.Chamado;
import br.com.qintess.domain.Cliente;
import br.com.qintess.domain.Tecnico;
import br.com.qintess.repositories.ChamadoRepository;
import br.com.qintess.repositories.ClienteRepository;
import br.com.qintess.repositories.PessoaRepository;
import br.com.qintess.repositories.TecnicoRepository;
import enums.Perfil;
import enums.Prioridade;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired(required = false)

	private PessoaRepository pessoaRepo;

	@Autowired
	private ChamadoRepository chamadoRepo;

	@Autowired
	private TecnicoRepository tecnicoRepo;

	@Autowired
	private ClienteRepository clienteRepo;

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		byte[] pass = "root".getBytes();
		Tecnico tec1 = new Tecnico(null, "Roger Cesar", "98938100678", "rogercesar@gmail.com",
				Base64.encodeBase64String(pass));
		tec1.addPerfil(Perfil.ADMIN);

		byte[] pass1 = "mestre".getBytes();

		Cliente cli1 = new Cliente(null, "linus Torvalds", "98946588765", "linus@outlook.com",
				Base64.encodeBase64String(pass1));
		cli1.addPerfil(Perfil.CLIENTE);

		Chamado c1 = new Chamado(null, Prioridade.BAIXA, enums.Status.ABERTO, "Troca de HD", "HD SATA NOVO", tec1,
				cli1);

		/* Adding the values on tables */

		tecnicoRepo.saveAll(Arrays.asList(tec1));
		clienteRepo.saveAll(Arrays.asList(cli1));
		chamadoRepo.saveAll(Arrays.asList(c1));

	}

}
