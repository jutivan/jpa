package br.com.fiap.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="x_item_pedido")
@IdClass(ItemPedidoPK.class)
public class ItemPedido {

	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_pedido")
	private Pedido pedido;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_produto")
	private Produto produto;
	
	/* 
	@Id
	@SequenceGenerator(name="seqItemPedido", sequenceName="sq_x_item_pedido", allocationSize=1)
	@GeneratedValue(generator="seqItemPedido", strategy=GenerationType.SEQUENCE)
	private int id;	
	 */

	@Column(name="qt_item")
	private int quantidade;
	
	public ItemPedido() {}

	public ItemPedido(int quantidade, Pedido pedido, Produto produto) {
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
}
