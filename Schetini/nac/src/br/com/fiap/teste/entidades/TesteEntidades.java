package br.com.fiap.teste.entidades;

import java.time.Month;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.AutorDAOImpl;
import br.com.fiap.dao.impl.EditoraDAOImpl;
import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entidades.Autor;
import br.com.fiap.entidades.Editora;
import br.com.fiap.entidades.Livro;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteEntidades {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		AutorDAOImpl autorDAO = new AutorDAOImpl(em);
		EditoraDAOImpl editoraDAO = new EditoraDAOImpl(em);
		LivroDAOImpl livroDAO = new LivroDAOImpl(em);
		
		Autor autor1 = new Autor(
				"Thiago Schetini Filosofo", 
				new GregorianCalendar(1979, Month.APRIL.getValue(), 20)
		);
		
		Autor autor2 = new Autor(
				"Zalman Coerxes", 
				new GregorianCalendar(1991, Month.FEBRUARY.getValue(), 13)
		);
		
		autorDAO.inserir(autor1);
		autorDAO.inserir(autor2);
		try {
			autorDAO.salvar();
		} catch (CommitException e) {
			e.printStackTrace();
			System.out.println("ERRO!");
		}
		
		Editora editora = new Editora("Editora Terar");
		editoraDAO.inserir(editora);
		try {
			editoraDAO.salvar();
		} catch (CommitException e) {
			e.printStackTrace();
			System.out.println("Erro!");
		}
		
		Livro livro1 = new Livro("Jardim de Chamas", null, editora);
		livro1.getAutores().add(autor1);
		livro1.getAutores().add(autor2);
		
		Livro livro2 = new Livro("Olavo de Carvalho", null, editora);
		livro2.getAutores().add(autor2);
		
		livroDAO.inserir(livro1);
		livroDAO.inserir(livro2);
		try {
			livroDAO.salvar();
		} catch (CommitException e) {
			e.printStackTrace();
			System.out.println("Erro");
		}
		
		em.close();
		System.out.println("sucesso ao inserir!");
	}
	
}
