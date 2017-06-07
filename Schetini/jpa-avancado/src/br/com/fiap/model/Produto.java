package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="x_produto")
@SequenceGenerator(name="seqProduto", sequenceName="sq_x_produto", allocationSize = 1)
public class Produto {

	@Id
	@Column(name="cd_produto")
	@GeneratedValue(generator="seqProduto", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_produto")
	private String nome;
	
	@Column(name="vl_produto")
	private double valor;

	public Produto() {}
	
	public Produto(int codigo, String nome, double valor) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
