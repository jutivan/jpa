package br.com.puchero.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pt_puta")
@SequenceGenerator(name="seqPuta", sequenceName="sq_puta", allocationSize=1)
public class Puta {

	
	@Id
	@Column(name="cd_puta")
	@GeneratedValue(generator="seqPuta")
	private int id;
	
	
	@Column(name="nm_puta")
	private String nome;
	
	
	@Column(name="vl_hora")	
	private double valorHora;
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_cafetina")
	private Cafetina cafetina;
	
	
	public Puta() {
	}
	
	public Puta(String nome, double hora) {
		this.nome = nome;
		this.valorHora = hora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double hora) {
		this.valorHora = hora;
	}
	
}
