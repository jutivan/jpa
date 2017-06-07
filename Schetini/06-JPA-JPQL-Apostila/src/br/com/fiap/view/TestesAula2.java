package br.com.fiap.view;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.entity.Pacote;

public class TestesAula2 {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ClienteDAOImpl clienteDAO = new ClienteDAOImpl(em);
		PacoteDAOImpl pacoteDAO = new PacoteDAOImpl(em);
		
		long qtdClientes = clienteDAO.qtdClientes();
		System.out.println(qtdClientes);
		
		long qtdClientesPorEstado = clienteDAO.qtdClientesPorEstado("SP");
		System.out.println(qtdClientesPorEstado);
		
		double precoMedioDosPacotes = pacoteDAO.precoMedioDosPacotes();
		System.out.println(precoMedioDosPacotes);
		
		long qtdPacotesComSaidaEntre = pacoteDAO.quantidadeSaidaEntre(new GregorianCalendar(2017, 1, 1), new GregorianCalendar(2017, 12, 30));
		System.out.println(qtdPacotesComSaidaEntre);
		
		List<Pacote> p = pacoteDAO.buscarMaiorPreco();
		p.forEach(i -> System.out.println(i.getPreco() + " " + i.getDescricao()));
	}
	
}
