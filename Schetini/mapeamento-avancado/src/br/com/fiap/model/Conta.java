package br.com.fiap.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="bco_conta")
@Inheritance(strategy=InheritanceType.JOINED)
@IdClass(ContaPK.class)
public abstract class Conta {

	@Id
	@Column(name="nr_conta")
	@SequenceGenerator(name="seqConta",sequenceName="bco_sq_conta" ,allocationSize=1)
	@GeneratedValue(generator="seqConta", strategy=GenerationType.SEQUENCE)
	private int numero;
	
	@Column(name="vl_saldo", nullable=false)
	private double saldo;

	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="nr_agencia", nullable=false)
	private Agencia agencia;
	
	public Conta() {}

	public Conta(double saldo, Agencia agencia) {
		this.saldo = saldo;
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
}
