package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.GrupoDAOImpl;
import br.com.fiap.dao.impl.ProjetoDAOImpl;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.model.Aluno;
import br.com.fiap.model.Grupo;
import br.com.fiap.model.Projeto;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastroGrupoAlunosCascadeTest {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance(); 
		EntityManager em = factory.createEntityManager();
		GrupoDAOImpl grupoDAO = new GrupoDAOImpl(em);
		
		Grupo grupo = new Grupo();
		grupo.setNome("Guerreiros");
		
		Projeto projeto = new Projeto();
		projeto.setTema("Arduino em Acao");
		grupo.setProjeto(projeto);	
		
		Aluno guilherme = new Aluno("Guilherme");
		Aluno jennifer = new Aluno("Jennifer");
		Aluno lucas = new Aluno("Lucas");
		grupo.addAluno(lucas);
		grupo.addAluno(guilherme);
		grupo.addAluno(jennifer);
		
		grupoDAO.create(grupo);
		try {
			grupoDAO.commit();
		} catch (CommitErrorException e) {
			System.out.println("erro");
		}
	}
	
}
