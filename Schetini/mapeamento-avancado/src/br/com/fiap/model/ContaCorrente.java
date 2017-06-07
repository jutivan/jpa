package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="bco_conta_corrente")
public class ContaCorrente extends Conta {

	@Column(name="vl_tarifa", nullable=false)
	private double tarifa;
	
	@Column(name="vl_cheque_especial")
	private double chequeEspecial;

	public ContaCorrente() {}
	
	public ContaCorrente(Agencia agencia, double saldo, double tarifa, double chequeEspecial) {
		super(saldo, agencia);
		this.tarifa = tarifa;
		this.chequeEspecial = chequeEspecial;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public double getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}
}
