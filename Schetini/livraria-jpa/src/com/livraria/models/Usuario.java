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
@SequenceGenerator(name="seqUsuario", sequenceName="seqUsuario", allocationSize=1)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 7412151910547479177L;

	@Id
	@GeneratedValue(generator="seqUsuario", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable=false, length=100)
	private String usuario;
	
	@Column(nullable=false, length=300)
	private String nome;
	
	@Column(length=300)
	private String sobrenome;
	
	@Column(nullable=false, length=20)
	private String cpf;

	public Usuario() {
	}
	
	public Usuario(String usuario, String nome, String sobrenome, String cpf) {
		this.usuario = usuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
