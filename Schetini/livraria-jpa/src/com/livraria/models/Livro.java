package com.livraria.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema="system")
@SequenceGenerator(name="seqLivro", sequenceName="seqLivro", allocationSize=1)
public class Livro implements Serializable {

	private static final long serialVersionUID = -4385557813506539547L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqLivro")
	private int isbn;
	
	@Column(nullable=false, length=200)
	private String titulo;
	
	@Column(scale=2)
	private double preco;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_lancamento")
	private Calendar dataLancamento;
	
	@Lob
	private byte[] capa;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
			name="autor_livro", 
			joinColumns=@JoinColumn(name="livro_isbn"), 
			inverseJoinColumns=@JoinColumn(name="autor_id")
	)
	private List<Autor> autores;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="editora_id")
	private Editora editora;

	public Livro() {
		autores = new ArrayList<Autor>();
	}

	public Livro(String titulo, double preco, Calendar dataLancamento, byte[] capa) {
		this.titulo = titulo;
		this.preco = preco;
		this.dataLancamento = dataLancamento;
		this.capa = capa;
		autores = new ArrayList<Autor>();
	}
	
	public Editora getEditora() {
		return editora;
	}
	
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	public List<Autor> getAutores() {
		return autores;
	}
	
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	public void addAutor(Autor autor) {
		autores.add(autor);
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public byte[] getCapa() {
		return capa;
	}

	public void setCapa(byte[] capa) {
		this.capa = capa;
	}
}
