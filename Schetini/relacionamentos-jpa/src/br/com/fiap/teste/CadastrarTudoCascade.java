package br.com.fiap.teste;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.GrupoDAOImpl;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.model.Aluno;
import br.com.fiap.model.Disciplina;
import br.com.fiap.model.Grupo;
import br.com.fiap.model.Projeto;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastrarTudoCascade {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		GrupoDAOImpl grupoDAO = new GrupoDAOImpl(em);

		Projeto projeto = new Projeto("Trabalho Natura");
		Grupo grupo = new Grupo("Grupo X", projeto);
		projeto.setGrupo(grupo);
		
		Aluno guilherme = new Aluno("Guilherme");
		Aluno jennifer = new Aluno("Jennifer");
		Aluno lucas = new Aluno("Lucas");
		grupo.addAluno(lucas);
		grupo.addAluno(guilherme);
		grupo.addAluno(jennifer);
		
		Disciplina matematica = new Disciplina("Matematica", 3);
		Disciplina geografia = new Disciplina("Geografia", 5);
		
		guilherme.addDisciplina(matematica);
		lucas.addDisciplina(geografia);
		jennifer.addDisciplina(matematica);
		jennifer.addDisciplina(geografia);
		
		grupoDAO.create(grupo);
		try {
			grupoDAO.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}
	}	
}
