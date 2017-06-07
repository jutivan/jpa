package com.livraria.teste;

import java.time.Month;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import com.livraria.dao.impl.AutorDAOImpl;
import com.livraria.dao.impl.EmprestimoDAOImpl;
import com.livraria.dao.impl.ExemplarDAOImpl;
import com.livraria.dao.impl.LivroDAOImpl;
import com.livraria.dao.impl.UsuarioDAOImpl;
import com.livraria.models.Autor;
import com.livraria.models.Emprestimo;
import com.livraria.models.Exemplar;
import com.livraria.models.Livro;
import com.livraria.models.Usuario;
import com.livraria.singleton.EntityManagerFactorySingleton;

public class TesteBuscas {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		LivroDAOImpl livroDAO = new LivroDAOImpl(em);
		EmprestimoDAOImpl emprestimoDAO = new EmprestimoDAOImpl(em);
		AutorDAOImpl autorDAO = new AutorDAOImpl(em);
		ExemplarDAOImpl exemplarDAO = new ExemplarDAOImpl(em);
		
		
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl(em);
		Usuario usuario = usuarioDAO.buscar(2);
		long qtd = emprestimoDAO.buscaQtdPorUsuario(usuario);
		System.out.println("O usuario com o id 1 tem " + qtd + " emprestimos realizados");

		
		List<Emprestimo> emprestimos = emprestimoDAO.buscaComDataEmprestimoEntre(
				new GregorianCalendar(2017, Month.APRIL.getValue(), 9),
				new GregorianCalendar(2017, Month.DECEMBER.getValue(), 10)
		);
		emprestimos.forEach(i -> System.out.println("emprestimo id: " + i.getId()));
		
		
		List<Livro> livrosLimite = livroDAO.buscaTodosComLimite(1);
		livrosLimite.forEach(i -> System.out.println("livro isbn: " + i.getIsbn() + " " + i.getTitulo() + " " + i.getEditora().getNome()));
		
		List<Livro> livrosTitulo = livroDAO.buscaPorTitulo("Os elfos");
		livrosTitulo.forEach(i -> System.out.println("livro isbn: " + i.getIsbn() + " " + i.getTitulo()));
		
		List<Livro> livrosEditora = livroDAO.buscarPelaEditora("Editora Moderna");
		livrosEditora.forEach(i -> System.out.println("R$ " + i.getPreco() + " " + i.getTitulo()));
		livrosEditora.forEach(i -> System.out.println("R$ " + i.getPreco() + " " + i.getTitulo()));
		
		Livro livro = livroDAO.buscar(1);
		List<Exemplar> buscarPorLivro = exemplarDAO.buscarPorLivro(livro);
		buscarPorLivro.forEach(i -> 
			System.out.println("exemplar comprado em " + i.getDataAquisicao() + " STATUS:" + i.getSituacao())
		);
		
		
		List<Autor> autores = autorDAO.buscaPeloNome("Thiago");
		autores.forEach(a -> System.out.println(a.getNome() + " " + a.getSoberenome()));
		
		
		em.close();
	}
}
