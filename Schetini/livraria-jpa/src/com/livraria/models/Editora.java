package com.livraria.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="system")
@SequenceGenerator(name="seqEditora", sequenceName="seqEditora", allocationSize=1)
public class Editora implements Serializable {

	private static final long serialVersionUID = 4741960624795883461L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqEditora")
	private int id;
	
	@Column(nullable=false, length=100)
	private String cnpj;
	
	@Column(nullable=false, length=300)
	private String nome;
	
	@Column(length=400)
	private String endereco;
	
	public Editora() {}

	public Editora(String cnpj, String nome, String endereco) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
