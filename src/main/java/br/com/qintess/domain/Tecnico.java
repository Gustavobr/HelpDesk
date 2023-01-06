package br.com.qintess.domain;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.qintess.DTO.TecnicoDTO;
import enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity(name = "TB_TECNICO")
public class Tecnico extends Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@OneToMany(mappedBy = "tecnico")
	private List<Chamado> chamados = new ArrayList<>();

	public Tecnico() {
		super();
		addPerfil(Perfil.TECNICO);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	public Tecnico(Integer id, String nome, String cpf, String email, String senha, Integer codigo) {
		super(id, nome, cpf, email, senha, codigo);
		addPerfil(Perfil.TECNICO);
	}

	public Tecnico(TecnicoDTO obj) throws IOException {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.codigo = obj.getCodigo();
		this.dataCriacao = obj.getDataCriacao();
	}

}
