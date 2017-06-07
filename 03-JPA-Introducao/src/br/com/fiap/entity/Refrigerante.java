package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_REFRIGERANTE")
@SequenceGenerator(name="seqRefri",sequenceName="SEQ_TB_REFRIGERANTE",allocationSize=1)
public class Refrigerante {

	@Id
	@Column(name="CD_REFRI")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqRefri")
	private int codigo;
	
	@Column(name="NM_REFRI",nullable=false,length=100)
	private String nome;
	
	@Column(name="DS_SABOR")
	private SaborRefrigerante sabor;
	
	@Column(name="DT_CADASTRO",nullable=false)
	@Temporal(TemporalType.TIMESTAMP) //Dia e hora
	private Calendar dataCadastro;
	
	@Column(name="VL_CALORIA")
	private float calorias;
	
	@Lob
	@Column(name="FL_ROTULO")
	private byte[] rotulo;
	
	public Refrigerante() {
		super();
	}

	public Refrigerante(int codigo, String nome, SaborRefrigerante sabor, Calendar dataCadastro, float calorias,
			byte[] rotulo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sabor = sabor;
		this.dataCadastro = dataCadastro;
		this.calorias = calorias;
		this.rotulo = rotulo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SaborRefrigerante getSabor() {
		return sabor;
	}

	public void setSabor(SaborRefrigerante sabor) {
		this.sabor = sabor;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public float getCalorias() {
		return calorias;
	}

	public void setCalorias(float calorias) {
		this.calorias = calorias;
	}

	public byte[] getRotulo() {
		return rotulo;
	}

	public void setRotulo(byte[] rotulo) {
		this.rotulo = rotulo;
	}
	
}
