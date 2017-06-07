package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	//Atributo privado e estático
	private static EntityManagerFactory fabrica;
	
	//Construtor privado
	private EntityManagerFactorySingleton() {}
	
	//Método publico e estático
	public static EntityManagerFactory getInstance(){
		if (fabrica == null){
			fabrica = Persistence
				.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return fabrica;
	}
	
}



