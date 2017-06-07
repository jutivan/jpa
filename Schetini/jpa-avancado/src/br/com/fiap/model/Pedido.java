package br.com.fiap.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="x_pedido")
@SequenceGenerator(name="seqPedido", sequenceName="sq_x_pedido", allocationSize = 1)
public class Pedido {

	@Id
	@Column(name="cd_pedido")
	@GeneratedValue(generator="seqPedido", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="dt_pedido")
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	@Column(name="nm_pedido")
	private String nome;
	
	public Pedido() {}

	public Pedido(int codigo, Calendar data, String nome) {
		this.codigo = codigo;
		this.data = data;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
