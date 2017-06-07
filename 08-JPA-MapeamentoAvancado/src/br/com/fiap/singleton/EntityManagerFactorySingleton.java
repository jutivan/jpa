package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	//Construtor privado
	private EntityManagerFactorySingleton() {}
	
	//Atributo privado estático
	private static EntityManagerFactory fabrica;
	
	//Método publico estático
	public static EntityManagerFactory getInstance(){
		if (fabrica == null){
			fabrica = Persistence
				.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return fabrica;
	}
	
}
