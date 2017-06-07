package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Editora;
import br.com.fiap.entity.Livro;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		LivroDAO dao = new LivroDAOImpl(em);
		
		Editora editora = new Editora("Abril", null);
		Autor autor = new Autor("Mauricio de Souza",
				Calendar.getInstance(),null);
		List<Autor> autores = new ArrayList<>();
		autores.add(autor);
		
		Livro livro = new Livro("123131313", 
			"Almanaque da monica", null, editora, autores);
		
		try {
			dao.cadastrar(livro);
			dao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}
		
		em.close();
		System.exit(0);
	}
	
}
