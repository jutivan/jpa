package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		//Criar o gerenciador de entidades:
		//Fabrica de Entity Manager
		EntityManagerFactory fabrica =   //configuração do persistence.xml
			Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

		//Com a fabrica, cria-se o gerenciador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		
		
		
	}
	
}
