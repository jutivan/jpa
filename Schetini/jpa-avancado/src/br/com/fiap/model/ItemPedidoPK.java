package br.com.fiap.model;

import java.io.Serializable;

public class ItemPedidoPK implements Serializable {

	private static final long serialVersionUID = 5915201532419900684L;

	private int pedido;
	
	private int produto;
	
	public ItemPedidoPK() {}

	public ItemPedidoPK(int pedido, int produto) {
		this.pedido = pedido;
		this.produto = produto;
	}

	public int getPedido() {
		return pedido;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

	public int getProduto() {
		return produto;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}
}
