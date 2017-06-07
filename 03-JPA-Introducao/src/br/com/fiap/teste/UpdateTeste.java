package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cerveja;
import br.com.fiap.entity.TipoCerveja;

public class UpdateTeste {

	public static void main(String[] args) {
		//Obter o EntityManager
		EntityManagerFactory fabrica = Persistence
			.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Find em uma cerveja
		Cerveja gelada = em.find(Cerveja.class, 1);
		
		//Alterar um atributo da cerveja
		gelada.setNome("Skol");
		gelada.setTipo(TipoCerveja.LAGER);
		
		//Alterar no banco de dados
		em.merge(gelada);
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		System.out.println("Cerveja atualizada!");
		System.exit(0);
		
		
	}
	
}
