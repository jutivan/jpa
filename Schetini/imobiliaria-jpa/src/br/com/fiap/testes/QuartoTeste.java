package br.com.fiap.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.QuartoDAOImpl;
import br.com.fiap.entity.Quarto;
import br.com.fiap.entity.TipoQuarto;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.IdNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class QuartoTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory manager = EntityManagerFactorySingleton.getInstance();
		EntityManager em = manager.createEntityManager();
		QuartoDAOImpl dao = new QuartoDAOImpl(em);
		
		Quarto quarto = new Quarto();
		quarto.setCor("Branco");
		quarto.setM2(21.5f);
		quarto.setSuite(true);
		quarto.setTipo(TipoQuarto.CASAL);
		
		dao.create(quarto);

		quarto.setM2(32.5f);
		dao.update(quarto);
		
		Quarto quartoBuscado = dao.find(1);
		System.out.println(quartoBuscado.getCor() + " " + quarto.getM2());
		
		Quarto quarto2 = new Quarto();
		quarto2.setCor("Rosa");
		quarto2.setM2(15f);
		quarto2.setSuite(false);
		quarto2.setTipo(TipoQuarto.CRIANCA);
		dao.create(quarto2);
		
		Quarto quarto3 = new Quarto();
		quarto3.setCor("Azul");
		quarto3.setM2(17f);
		quarto3.setSuite(false);
		quarto3.setTipo(TipoQuarto.CRIANCA);
		dao.create(quarto3);
		
		try {
			dao.delete(2);
		} catch (IdNotFoundException e1) {
			System.out.println("Id nao encontrado para remover");
		}
		
		try {
			dao.commit();
		} catch (CommitException e) {
			System.out.println("Erro ao fazer commit no banco de dados!");
		}
	}	
}
