package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ItemPedidoDAO;
import br.com.fiap.model.ItemPedido;
import br.com.fiap.model.ItemPedidoPK;

public class ItemPedidoDAOImpl extends GenericDAOImpl<ItemPedido, ItemPedidoPK> implements ItemPedidoDAO {

	public ItemPedidoDAOImpl(EntityManager em) {
		super(em);
	}

}
