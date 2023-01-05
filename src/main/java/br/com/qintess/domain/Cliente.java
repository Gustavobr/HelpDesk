package br.com.qintess.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity(name = "TB_CLIENTE")
public class Cliente extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente(Integer id, String nome, String cpf, String email, String senha, Integer codigo) {
		super(id, nome, cpf, email, senha, codigo);
		addPerfil(Perfil.CLIENTE);
	}

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Chamado> chamados = new ArrayList<>();

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

}
