package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_PEDIDO")
@IdClass(ItemPedidoPK.class)
public class ItemPedido {

	@Id
	@JoinColumn(name="CD_PEDIDO")
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Pedido pedido;
	
	@Id
	@JoinColumn(name="CD_PRODUTO")
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Produto produto;

	@Column(name="QT_ITEM")
	private int quantidade;
	
	public ItemPedido(Pedido pedido, Produto produto, int quantidade) {
		super();
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public ItemPedido() {
		super();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
