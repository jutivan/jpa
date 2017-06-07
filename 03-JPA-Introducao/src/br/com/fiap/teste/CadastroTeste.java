package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cerveja;
import br.com.fiap.entity.TipoCerveja;

public class CadastroTeste {

	public static void main(String[] args) {
		//Obter uma instancia da Fabrica
		EntityManagerFactory fabrica = Persistence
			.createEntityManagerFactory("CLIENTE_ORACLE");
		//Obter uma instancia do EntityManager
		EntityManager em = fabrica.createEntityManager();	
		
		//Instanciar uma cerveja/refrigerante
		Cerveja breja = new Cerveja(0, "Krill", 
			0.05f, 1, Calendar.getInstance(), 
			new GregorianCalendar(2020,Calendar.JANUARY,1),
			TipoCerveja.PILSEN, null, false);
		
		//Cadastrar a cerveja
		em.persist(breja);
		
		//Transação
		//Incializa uma transação
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		System.out.println("Cerveja registrada!");
		System.exit(0);
		
	}
	
}
