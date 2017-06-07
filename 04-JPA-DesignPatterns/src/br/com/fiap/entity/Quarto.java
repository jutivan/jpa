package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_QUARTO")
@SequenceGenerator(name="seqQuarto",sequenceName="SQ_TB_QUARTO",allocationSize=1)
public class Quarto {

	@Id
	@Column(name="CD_QUARTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqQuarto")
	private int codigo;
	
	@Column(name="NR_METRO_QUADRADO")
	private float m2;
	
	@Column(name="DS_TIPO")
	private TipoQuarto tipo;
	
	@Column(name="DS_SUITE")
	private boolean suite;
	
	public Quarto() {
		super();
	}

	public Quarto(int codigo, float m2, TipoQuarto tipo, boolean suite) {
		super();
		this.codigo = codigo;
		this.m2 = m2;
		this.tipo = tipo;
		this.suite = suite;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getM2() {
		return m2;
	}

	public void setM2(float m2) {
		this.m2 = m2;
	}

	public TipoQuarto getTipo() {
		return tipo;
	}

	public void setTipo(TipoQuarto tipo) {
		this.tipo = tipo;
	}

	public boolean isSuite() {
		return suite;
	}

	public void setSuite(boolean suite) {
		this.suite = suite;
	}
	
}
