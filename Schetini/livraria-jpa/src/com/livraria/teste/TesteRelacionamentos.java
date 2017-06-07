package com.livraria.teste;

import java.time.Month;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import com.livraria.dao.impl.EmprestimoDAOImpl;
import com.livraria.dao.impl.LivroDAOImpl;
import com.livraria.enums.Sexo;
import com.livraria.exceptions.CommitException;
import com.livraria.models.Autor;
import com.livraria.models.Editora;
import com.livraria.models.Emprestimo;
import com.livraria.models.Exemplar;
import com.livraria.models.Livro;
import com.livraria.models.Situacao;
import com.livraria.models.Usuario;
import com.livraria.singleton.EntityManagerFactorySingleton;

public class TesteRelacionamentos {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		LivroDAOImpl livroDAO = new LivroDAOImpl(em);
		EmprestimoDAOImpl emprestimoDAO = new EmprestimoDAOImpl(em);
		
		
		/**
		 * Editora, autores e livros
		 */
		Editora editora = new Editora("3333344444", "Editora Moderna", "Avenida das Araras 500");
		
		Autor thiago = new Autor(
				"Thiago", 
				Sexo.MASCULINO, 
				"Schetini", 
				new GregorianCalendar(1985,Month.FEBRUARY.getValue(),10)
		);
		
		Autor pedro = new Autor(
				"Pedro", 
				Sexo.MASCULINO, 
				"Soares", 
				new GregorianCalendar(1999, Month.AUGUST.getValue(), 10)
		);
		
		Livro livro1 = new Livro(
				"Jardim das Multidoes", 
				39.40, 
				new GregorianCalendar(2016, Month.AUGUST.getValue(), 15), 
				null
		);
		
		Livro livro2 = new Livro(
				"Os elfos", 
				29.90, 
				new GregorianCalendar(2015, Month.JULY.getValue(), 1), 
				null
		);
		
		livro1.setEditora(editora);
		livro1.addAutor(thiago);
		livro1.addAutor(pedro);
		livro2.setEditora(editora);
		livro2.addAutor(thiago);
		livroDAO.inserir(livro1);
		livroDAO.inserir(livro2);
		try {
			livroDAO.salvar();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		
		/**
		 * Exemplares, emprestimos e usuarios
		 */
		Exemplar exemplar1 = new Exemplar(
				new GregorianCalendar(2016, Month.DECEMBER.getValue(), 11), 
				Situacao.DISPONIVEL, 
				livro1
		);
		
		Exemplar exemplar2 = new Exemplar(
				new GregorianCalendar(2016, Month.DECEMBER.getValue(), 19), 
				Situacao.DISPONIVEL, 
				livro1
		);
		
		Exemplar exemplar3 = new Exemplar(
				new GregorianCalendar(2016, Month.DECEMBER.getValue(), 11), 
				Situacao.DISPONIVEL, 
				livro2
		);
		
		Exemplar exemplar4 = new Exemplar(
				new GregorianCalendar(2016, Month.DECEMBER.getValue(), 20), 
				Situacao.DISPONIVEL, 
				livro2
		);
		
		Emprestimo emprestimo1 = new Emprestimo(
				new GregorianCalendar(2017, Month.APRIL.getValue(), 10), 
				new GregorianCalendar(2017, Month.MAY.getValue(), 10),
				new Usuario("patrick-123", "Patrick", "Manuelle Oliveira", "123423")
		);
		emprestimo1.addExemplar(exemplar1);
		exemplar1.setSituacao(Situacao.EMPRESTADO);
		emprestimo1.addExemplar(exemplar2);
		exemplar2.setSituacao(Situacao.EMPRESTADO);
		
		Emprestimo emprestimo2 = new Emprestimo(
				new GregorianCalendar(2017, Month.APRIL.getValue(), 10), 
				new GregorianCalendar(2017, Month.JUNE.getValue(), 10),
				new Usuario("rick-123", "Rick", "Fransoar", "123321")
		);
		emprestimo2.addExemplar(exemplar3);
		exemplar3.setSituacao(Situacao.EMPRESTADO);
		emprestimo2.addExemplar(exemplar4);
		exemplar4.setSituacao(Situacao.EMPRESTADO);
		
		emprestimoDAO.inserir(emprestimo1);
		emprestimoDAO.inserir(emprestimo2);
		try {
			emprestimoDAO.salvar();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		
		em.close();
	}
	
}
