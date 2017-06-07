package br.com.fiap.teste;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ContaCorrenteDAOImpl;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Agencia;
import br.com.fiap.model.ContaCorrente;

public class ContaCorrenteTeste {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ContaCorrenteDAOImpl dao = new ContaCorrenteDAOImpl(em);
		
		dao.cadastrar(new ContaCorrente(
						new Agencia("Av das araras 500"), 
						1280.45, 
						13.90, 
						820
						)
		);
		
		try {
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}
	
}
