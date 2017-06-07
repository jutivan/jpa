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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema="system")
@SequenceGenerator(name="seqExemplar", sequenceName="seqExemplar", allocationSize=1)
public class Exemplar implements Serializable {

	private static final long serialVersionUID = 3257851764510088170L;

	@Id
	@GeneratedValue(generator="seqExemplar", strategy=GenerationType.SEQUENCE)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_aquisicao")
	private Calendar dataAquisicao;
	
	@Column(nullable=false)
	private Situacao situacao;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="livro_isbn")
	private Livro livro;
	
	@ManyToMany(mappedBy="exemplares", cascade=CascadeType.PERSIST)
	private List<Emprestimo> emprestimos;
	
	public Exemplar() {}

	public Exemplar(Calendar dataAquisicao, Situacao situacao, Livro livro) {
		this.dataAquisicao = dataAquisicao;
		this.situacao = situacao;
		this.livro = livro;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Calendar dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
}
