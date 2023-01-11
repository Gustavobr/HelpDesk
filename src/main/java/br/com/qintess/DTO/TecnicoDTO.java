package br.com.qintess.DTO;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.qintess.domain.Pessoa;
import br.com.qintess.domain.Tecnico;
import enums.Perfil;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

public class TecnicoDTO extends Pessoa implements Serializable {

	public TecnicoDTO() {
		super();
		addPerfil(Perfil.TECNICO);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TecnicoDTO(Integer id, String nome, String cpf, String email, String senha, LocalDate dataCriacao,
			Integer codigo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		// this.perfis = perfis;
		this.dataCriacao = dataCriacao;
		this.codigo = codigo;
	}

	protected Integer id;

	@NotNull(message = "Favor inserir nome do técnico")
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

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> {
			try {
				return Perfil.to_ENUM(x);
			} catch (IOException e) {

				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toSet());
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

	@NotNull(message = "Favor inserir cpf")
	protected String cpf;
	@NotNull(message = "Favor inserir E-mail")
	protected String email;
	@NotNull(message = "Digitar Senha")
	@Size(min = 5, message = "Senha deve ter mínimo de 5 caracteres")
	protected String senha;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	protected Integer codigo;

	protected Set<Integer> perfis = new HashSet<>();

	@Null
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();

}
