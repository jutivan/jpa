package br.com.fiap.entity;

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
@Table(name="TB_PROJETO_AM")
@SequenceGenerator(name="seqProjeto",
sequenceName="SQ_TB_PROJETO_AM", allocationSize=1)
public class ProjetoAm {

	@Id
	@Column(name="CD_PROJETO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="seqProjeto")
	private int codigo;
	
	@Temporal(TemporalType.TIMESTAMP)//data e hora
	@Column(name="DT_ENTREGA")
	private Calendar dataEntrega;
	
	@Column(name="DS_TEMA",nullable=false,length=200)
	private String tema;
	
	@Column(name="DS_OBSERVACAO")
	private String observacao;
	
	@Column(name="VL_NOTA")
	private float nota;
	
	//cascade -> replica a ação configurada na relação
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="CD_GRUPO")
	private GrupoAm grupo;

	public ProjetoAm() {
		super();
	}

	public ProjetoAm(int codigo, Calendar dataEntrega, String tema, String observacao, float nota, GrupoAm grupo) {
		super();
		this.codigo = codigo;
		this.dataEntrega = dataEntrega;
		this.tema = tema;
		this.observacao = observacao;
		this.nota = nota;
		this.grupo = grupo;
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

	public GrupoAm getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoAm grupo) {
		this.grupo = grupo;
	}
	
	
	
}
