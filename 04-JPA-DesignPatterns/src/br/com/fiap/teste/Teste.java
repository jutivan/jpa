package br.com.fiap.teste;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ApartamentoDAO;
import br.com.fiap.dao.impl.ApartamentoDAOImpl;
import br.com.fiap.entity.Apartamento;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		//Cadastrar o apartamento
		Apartamento ap = new Apartamento();
		ap.setEndereco("Av Lins de Vasconcelos, 1222");
		
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		ApartamentoDAO dao = 
					new ApartamentoDAOImpl(em);
		
		dao.create(ap);
		
		em.close();
		System.exit(0);
	}
	
}
