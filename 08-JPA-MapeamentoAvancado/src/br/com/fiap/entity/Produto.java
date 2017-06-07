package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqProduto",sequenceName="SQ_PRODUTO",allocationSize=1)
public class Produto {

	@Id
	@Column(name="CD_PRODUTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqProduto")
	private int codigo;
	
	@Column(name="NM_PRODUTO")
	private String nome;
	
	@Column(name="VL_PRODUTO")
	private double preco;
	
	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}

	public Produto() {
		super();
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
