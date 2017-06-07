package br.com.fiap.teste;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ContaPoupancaDAOImpl;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Agencia;
import br.com.fiap.model.ContaPoupanca;

public class ContaPoupancaTeste {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ContaPoupancaDAOImpl dao = new ContaPoupancaDAOImpl(em);
		
		dao.cadastrar(new ContaPoupanca(
						3333,
						new Agencia("Av das araras 500"), 
						33
					)
		);
		
		try {
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
		}

		
	}
	
}
