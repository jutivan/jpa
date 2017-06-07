package br.com.fiap.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="am_projeto", schema="system")
@SequenceGenerator(name="seqProjeto", sequenceName="sq_projeto", allocationSize=1)
public class Projeto {

	@Id
	@Column(name="cd_projeto")
	@GeneratedValue(generator="seqProjeto", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="dt_entrega")
	@Temporal(TemporalType.TIMESTAMP) // data e hora
	private Calendar dataEntrega;
	
	@Column(name="ds_tema", nullable=false, length=200)
	private String tema;
	
	@Column(name="ds_observcacao")
	private String observacao;
	
	@Column(name="vl_nota", precision=2, scale=2)
	private float nota;
	
	@OneToOne
	@JoinColumn(name="cd_grupo")
	private Grupo grupo;
	
	public Projeto() {
	}

	public Projeto(String tema) {
		this.tema = tema;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}
