package br.com.qintess.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity(name = "TB_TECNICO")
public class Tecnico extends Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.TECNICO);
	}
}
