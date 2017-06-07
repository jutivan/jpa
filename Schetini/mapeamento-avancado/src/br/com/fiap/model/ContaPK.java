package br.com.fiap.model;

import java.io.Serializable;

public class ContaPK implements Serializable {

	private static final long serialVersionUID = 1685441602402076895L;

	private int numero;
	
	private int agencia;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
}
