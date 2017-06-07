
package br.com.puchero.teste;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import br.com.puchero.dao.impl.PucheroDAOImpl;
import br.com.puchero.dao.singleton.EntityManagerFactorySingleton;
import br.com.puchero.exception.TransacaoException;
import br.com.puchero.model.Cafetina;
import br.com.puchero.model.Puchero;
import br.com.puchero.model.Puta;

public class PucheroTeste {

	public static void main(String[] args) {
		
		Puchero puchero = new Puchero("Hominus Erectus");
		Cafetina cafetina = new Cafetina("Suzi");
		Puta tiffany = new Puta("Tiffany", 190.00);
		Puta suellen = new Puta("Suellen", 230.00);
		
		ArrayList<Puta> putas = new ArrayList<>();
		putas.add(tiffany);
		putas.add(suellen);
		cafetina.setPutas(putas);

		ArrayList<Cafetina> cafetinas = new ArrayList<>();
		cafetinas.add(cafetina);
		puchero.setCafetinas(cafetinas);
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		PucheroDAOImpl pucheroDAO = new PucheroDAOImpl(em);
		
		pucheroDAO.inserir(puchero);
		try {
			pucheroDAO.efectivarTransacao();
			System.out.println("sucesso!");
		} catch (TransacaoException e) {
			System.out.println("erro ao efectivar a transacione");
		}
		
	}
	
}
