package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.PacoteDAO;

public class Exercicio09 {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		PacoteDAO dao = new PacoteDAOImpl(em);
		
		System.out.println("Preço médio: "
						+ dao.calcularPrecoMedio());
		
		em.close();
		System.exit(0);
	}
	
}
