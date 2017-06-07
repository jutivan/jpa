package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="bco_conta_poupanca")
public class ContaPoupanca extends Conta  {

	@Column(name="vl_rendimento", nullable=false)
	private double rendimento;

	public ContaPoupanca() {}

	public ContaPoupanca(double saldo, Agencia agencia, double rendimento) {
		super(saldo, agencia);
		this.rendimento = rendimento;
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}
}
