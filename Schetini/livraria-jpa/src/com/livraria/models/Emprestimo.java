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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema="system")
@SequenceGenerator(name="seqEmprestimo", sequenceName="seqEmprestimo", allocationSize=1)
public class Emprestimo implements Serializable {

	private static final long serialVersionUID = -8823015260545177042L;

	@Id
	@GeneratedValue(generator="seqEmprestimo", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_emprestimo", nullable=false)
	private Calendar dataEmprestimo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_retorno", nullable=false)
	private Calendar dataRetorno;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
			name="emprestimo_exemplar",
			joinColumns=@JoinColumn(name="emprestimo_id"),
			inverseJoinColumns=@JoinColumn(name="exemplar_id")
	)
	private List<Exemplar> exemplares;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	public Emprestimo() {
		exemplares = new ArrayList<Exemplar>();
	}

	public Emprestimo(Calendar dataEmprestimo, Calendar dataRetorno, Usuario usuario) {
		this.dataEmprestimo = dataEmprestimo;
		this.dataRetorno = dataRetorno;
		this.usuario = usuario;
		exemplares = new ArrayList<Exemplar>();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Exemplar> getExemplares() {
		return exemplares;
	}
	
	public void setExemplares(List<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}
	
	public void addExemplar(Exemplar exemplar) {
		exemplares.add(exemplar);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Calendar getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Calendar dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	
}
