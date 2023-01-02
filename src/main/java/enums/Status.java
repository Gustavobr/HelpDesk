package enums;

import java.io.IOException;

public enum Status {
	ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

	private Integer codigo;

	private String descricao;

	Status(Integer codigo, String descricao) {

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

	public static Status to_ENUM(Integer codigo) throws IOException {
		if (codigo == null) {
			return null;
		}
		for (Status status : Status.values()) {
			if (codigo.equals(status.getCodigo())) {
				return status;
			}
		}
		throw new IllegalArgumentException("Status inválido.");

	}

}
