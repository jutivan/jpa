package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	//Atributo privado e est�tico
	private static EntityManagerFactory fabrica;
	
	//Construtor privado
	private EntityManagerFactorySingleton() {}
	
	//M�todo publico e est�tico
	public static EntityManagerFactory getInstance(){
		if (fabrica == null){
			fabrica = Persistence
				.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return fabrica;
	}
	
}



