package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_quarto", schema="system")
@SequenceGenerator(name="seqQuarto", sequenceName="sq_quarto", allocationSize=1)
public class Quarto {

	@Id
	@Column(name="cd_quarto")
	@GeneratedValue(generator="seqQuarto", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nr_metro_quadrado")
	private float m2;
	
	@Column(name="nm_cor")
	private String cor;
	
	@Column(name="ds_tipo")
	private TipoQuarto tipo;
	
	@Column(name="ds_suite")
	private boolean suite;
	
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
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
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
