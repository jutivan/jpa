package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cerveja;

public class RemoveTest {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence
			.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar
		Cerveja cerveja = em.find(Cerveja.class, 1);
		//Remover
		em.remove(cerveja);

		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		System.out.println("Cerveja removida!");
		System.exit(0);
	}
	
}
