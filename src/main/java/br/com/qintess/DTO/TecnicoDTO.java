package br.com.qintess.DTO;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.qintess.domain.Tecnico;
import enums.Perfil;

public class TecnicoDTO implements Serializable {

	public TecnicoDTO() {
		super();

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TecnicoDTO(Integer id, String nome, String cpf, String email, String senha, Set<Integer> perfis,
			LocalDate dataCriacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.perfis = perfis;
		this.dataCriacao = dataCriacao;
	}

	protected Integer id;
	protected String nome;

	public TecnicoDTO(Tecnico obj) throws IOException {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}

	public TecnicoDTO(Object object, String nome2, String cpf2, String email2, String senha2, Integer perfil,
			LocalDate dataCriacao2) {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Integer> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Integer> perfis) {
		this.perfis = perfis;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	protected String cpf;

	protected String email;

	protected String senha;

	protected Set<Integer> perfis = new HashSet<>();

	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();

}
