package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.ProjetoAmDAO;
import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.dao.impl.ProjetoAmDAOImpl;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.entity.ProjetoAm;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastroGrupoProjetoView {

	public static void main(String[] args) {
		//Cadastrar um grupo e um projeto relacionados
		//Obter uma instancia do EntityManager
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar os DAOs
		GrupoAmDAO grupoDao = new GrupoAmDAOImpl(em);
		ProjetoAmDAO projetoDao = new ProjetoAmDAOImpl(em);
		
		//Instanciar um grupo e um projeto
		GrupoAm grupo = new GrupoAm();
		grupo.setNome("While true");
		
		ProjetoAm projeto = new ProjetoAm(0, 
			new GregorianCalendar(2017, Calendar.OCTOBER, 2),
			"Cuide da saude",null,10,grupo);
		
		//Utilizar o DAO para cadastrar
		//grupoDao.create(grupo);
		projetoDao.create(projeto);
		
		try {
			//Commit
			projetoDao.commit();
			//Sucesso!
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}finally {
			em.close();
			fabrica.close();
			System.exit(0); //Fecha o programa
		}
	}
	
}