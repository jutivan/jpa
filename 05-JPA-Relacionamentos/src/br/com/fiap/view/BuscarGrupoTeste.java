package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class BuscarGrupoTeste {

	public static void main(String[] args) {
		//Buscar o grupo e exibir o nome do grupo e projeto		
		//Obter o entityManager
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		//Intanciar o DAO do Grupo
		GrupoAmDAO dao = new GrupoAmDAOImpl(em);
		//Buscar o grupo com código 1
		GrupoAm grupo = dao.find(1);
		//Exibir os nomes
		System.out.println(grupo.getNome());
		System.out.println(grupo.getProjeto().getTema());
		//Sucesso!
		em.close();
		System.exit(0);
	}
	
}
