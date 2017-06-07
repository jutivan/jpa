package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="bco_agencia")
@SequenceGenerator(name="seqAgencia",sequenceName="bco_sq_agencia" ,allocationSize=1)
public class Agencia {

	@Id
	@Column(name="nr_agencia")
	@GeneratedValue(generator="seqAgencia", strategy=GenerationType.SEQUENCE)
	private int numero;
	
	@Column(name="ds_endereco")
	private String endereco;
	
	public Agencia() {}

	public Agencia(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
