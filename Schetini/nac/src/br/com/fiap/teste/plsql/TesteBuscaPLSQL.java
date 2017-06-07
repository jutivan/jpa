package br.com.fiap.teste.plsql;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.EditoraDAOImpl;
import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entidades.Livro;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteBuscaPLSQL {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		LivroDAOImpl livroDAO = new LivroDAOImpl(em);
		
		List<Livro> buscaPeloTitulo = livroDAO.buscaPeloTitulo("Olavo de Carvalho");
		buscaPeloTitulo.forEach(l -> 
			System.out.println(
					"Livro encontrado pelo titulo: " + l.getTitulo() + " :: ISBN:" + l.getIsbn()
			)
		);
		
		List<Livro> buscarPeloNomeDaEditora = livroDAO.buscarPeloNomeDaEditora("Editora Terar");
		buscarPeloNomeDaEditora.forEach(l -> 
			System.out.println(
					"Livro encontrado pelo nome da editora: " + l.getTitulo() + " :: ISBN:" + l.getIsbn()
			)
		);
		
		EditoraDAOImpl editoraDAO = new EditoraDAOImpl(em);
		long quantidadeLivros = livroDAO.contarLivrosPelaEditora(editoraDAO.buscar(2));
		System.out.println("Encontrados " + quantidadeLivros + " da editora");
		
		em.close();
	}
	
}
