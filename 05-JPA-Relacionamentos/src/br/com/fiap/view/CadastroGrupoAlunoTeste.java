package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastroGrupoAlunoTeste {

	public static void main(String[] args) {
		//Instanciar o EntityManager
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		//Instanciar o DAO
		GrupoAmDAO dao = new GrupoAmDAOImpl(em);
		
		//Instanciar o Grupo
		GrupoAm grupo = new GrupoAm();
		grupo.setNome("Compilou");
		
		//Instanciar os Alunos
		//Adicionar os alunos no grupo
		grupo.addAluno(new Aluno("Victinho"));
		grupo.addAluno(new Aluno("Mathuzinho"));
		grupo.addAluno(new Aluno("Vinicius"));
		grupo.addAluno(new Aluno("Danileira"));
		grupo.addAluno(new Aluno("Margo"));
		
		try {
			//Cadastrar com commit!
			dao.create(grupo);
			//Sucesso!
			dao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}finally {
			em.close();
			System.exit(0);
		}
	}
}