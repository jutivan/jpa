package br.com.empresa.view;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.empresa.dao.impl.DependenteDAOImpl;
import br.com.empresa.exception.CommitErrorException;
import br.com.empresa.model.Dependente;
import br.com.empresa.model.Funcionario;
import br.com.empresa.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		DependenteDAOImpl dao = new DependenteDAOImpl(em);

		Funcionario victor = new Funcionario(0,"Vitinho Souza", new GregorianCalendar(1993, 10, 20));
		victor.setAgencia(1992);
		victor.setConta(12345);
		victor.setSalario(7000);
		
		Dependente dependente = new Dependente(0, victor, "Viviane");
		
		try {
			dao.create(dependente);
			dao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}
		
		em.close();
	}
}
