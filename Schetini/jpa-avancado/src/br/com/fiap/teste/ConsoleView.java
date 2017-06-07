package br.com.fiap.teste;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.ItemPedidoDAO;
import br.com.fiap.dao.impl.ItemPedidoDAOImpl;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.ItemPedido;
import br.com.fiap.model.Pedido;
import br.com.fiap.model.Produto;

public class ConsoleView {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ItemPedidoDAO dao = new ItemPedidoDAOImpl(em);
		GregorianCalendar hoje = new GregorianCalendar(2017,4,19);
		
		dao.cadastrar(
				new ItemPedido(
						3, 
						new Pedido(0, hoje, "Thiago Schetini"), 
						new Produto(0, "Notebook", 1299)
				)
		);
		
		try {
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
