package br.com.fiap.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.ApartamentoDAOImpl;
import br.com.fiap.dao.impl.QuartoDAOImpl;
import br.com.fiap.entity.Apartamento;
import br.com.fiap.entity.Quarto;
import br.com.fiap.entity.TipoQuarto;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		//cadastrar o apartamento
		Apartamento apartamento = new Apartamento();
		apartamento.setEndereco("Avenida Herbert Viana");
		
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		ApartamentoDAOImpl dao = new ApartamentoDAOImpl(em);
		
		
		QuartoDAOImpl quartoDAO = new QuartoDAOImpl(em);
		
		Quarto quarto = new Quarto();
		quarto.setCor("Branco");
		quarto.setM2(21.5f);
		quarto.setSuite(true);
		quarto.setTipo(TipoQuarto.CASAL);
		
		quartoDAO.create(quarto);
		
		apartamento.adicionaQuarto(quarto);
		
		dao.create(apartamento);
		
		try {
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			System.out.println("Erro ao fazer o commit");
		}
		
	}
	
}
