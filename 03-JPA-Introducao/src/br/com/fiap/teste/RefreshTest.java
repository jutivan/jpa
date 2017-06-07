package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cerveja;

public class RefreshTest {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence
			.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar uma cerveja no banco
		Cerveja cerveja = em.find(Cerveja.class, 1);
		//Exibir o nome
		System.out.println("Nome do banco: " 
							+ cerveja.getNome());
		//Mudar o nome
		cerveja.setNome("Kaiser");
		//Exibir o nome
		System.out.println("Nome alterado (objeto): " 
							+ cerveja.getNome());
		//Fazer o refresh
		em.refresh(cerveja);
		//Exibir o nome
		System.out.println("Nome após o refresh: " 
							+ cerveja.getNome());
		em.close();
		System.exit(0);
	}
	
}
