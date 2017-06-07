package com.livraria.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.livraria.enums.Sexo;

@Entity
@Table(schema="system")
@SequenceGenerator(name="seqAutor", sequenceName="seqAutor", allocationSize=1)
public class Autor implements Serializable {

	private static final long serialVersionUID = -1583828104577818267L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqAutor")
	private int id;
	
	@Column(nullable=false, length=200)
	private String nome;

	@Column(nullable=false)
	private Sexo sexo;
	
	@Column(nullable=false, length=300)
	private String soberenome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@ManyToMany(mappedBy="autores", cascade=CascadeType.PERSIST)
	private List<Livro> livros;
	
	public Autor() {}

	public Autor(String nome, Sexo sexo, String soberenome, Calendar dataNascimento) {
		this.nome = nome;
		this.sexo = sexo;
		this.soberenome = soberenome;
		this.dataNascimento = dataNascimento;
	}
	
	public List<Livro> getLivros() {
		return livros;
	}
	
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getSoberenome() {
		return soberenome;
	}

	public void setSoberenome(String soberenome) {
		this.soberenome = soberenome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
