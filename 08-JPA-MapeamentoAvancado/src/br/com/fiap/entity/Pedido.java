package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="seqPedido",sequenceName="SQ_PEDIDO",allocationSize=1)
public class Pedido {

	@Id
	@Column(name="CD_PEDIDO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqPedido")
	private int codigo;
	
	@Column(name="NM_CLIENTE")
	private String cliente;
	
	@Column(name="DT_PEDIDO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	public Pedido() {
		super();
	}

	public Pedido(String cliente, Calendar data) {
		super();
		this.cliente = cliente;
		this.data = data;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
}
