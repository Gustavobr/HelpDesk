package enums;

import java.io.IOException;

public enum Prioridade {
	BAIXA(0, "BAIXA"), MEDIA(1, "Média"), ALTA(2, "ALTA");

	private Integer codigo;

	private String descricao;

	Prioridade(Integer codigo, String descricao) {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static Prioridade to_ENUM(Integer codigo) throws IOException {
		if (codigo == null) {
			return null;
		}
		for (Perfil p : Perfil.values()) {
			if (codigo.equals(p.getCodigo())) {
				return p;
			}
		}
		throw new IllegalArgumentException("Prioridade inválida.");

	}

}
