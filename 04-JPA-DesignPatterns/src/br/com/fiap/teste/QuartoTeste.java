package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.QuartoDAO;
import br.com.fiap.dao.impl.QuartoDAOImpl;
import br.com.fiap.entity.Quarto;
import br.com.fiap.entity.TipoQuarto;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class QuartoTeste {

	public static void main(String[] args) {
		//Cadastrar um quarto:		
		//Criar um quarto
		Quarto quarto = new Quarto(0, 9, 
				TipoQuarto.CASAL, true);
		
		//Criar o quartoDAO
			
		EntityManager em = 
				EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		QuartoDAO dao = new QuartoDAOImpl(em);
		try {
			//cadastrar
			dao.create(quarto);
			dao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		System.exit(0);
	}
}
