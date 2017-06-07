package br.com.fiap.view;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.DependenteDAO;
import br.com.fiap.dao.impl.DependenteDAOImpl;
import br.com.fiap.entity.Dependente;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		//Cadastrar um funcionário e um dependente
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		DependenteDAO dao = new DependenteDAOImpl(em);
		
		Funcionario func = new Funcionario();
		func.setNome("Victinho");
		func.setDataNascimento(
			new GregorianCalendar(1990, 1, 2));
		func.setSalario(5000);
		func.setConta(123);
		func.setAgencia(321);
		
		Dependente dep = new Dependente();
		dep.setFuncionario(func);
		dep.setNome("Jaque");		
		
		try {
			dao.create(dep);
			dao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}
		
		em.close();
		System.exit(0);
	}
	
}

