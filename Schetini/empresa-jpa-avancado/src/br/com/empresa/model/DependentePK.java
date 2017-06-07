package br.com.empresa.model;

import java.io.Serializable;

public class DependentePK implements Serializable {

	private static final long serialVersionUID = 8226499955667111079L;

	private int codigo;
	
	private int funcionario;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(int funcionario) {
		this.funcionario = funcionario;
	}
}
