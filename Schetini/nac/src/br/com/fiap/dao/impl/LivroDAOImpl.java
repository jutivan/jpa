package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.entidades.Editora;
import br.com.fiap.entidades.Livro;

public class LivroDAOImpl extends GenericDAOImpl<Livro, Integer> implements LivroDAO {

	public LivroDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Livro> buscaPeloTitulo(String titulo) {
		return getEntityManager()
				.createQuery("from Livro l where l.titulo = :titulo", Livro.class)
				.setParameter("titulo", titulo)
				.setMaxResults(50)
				.getResultList();
	}

	@Override
	public long contarLivrosPelaEditora(Editora editora) {
		return getEntityManager()
				.createQuery("select count(l.isbn) from Livro l where l.editora = :editora", Long.class)
				.setParameter("editora", editora)
				.getSingleResult();
	}

	@Override
	public List<Livro> buscarPeloNomeDaEditora(String nome) {
		return getEntityManager()
				.createQuery("from Livro l where l.editora.nome = :nome", Livro.class)
				.setParameter("nome", nome)
				.getResultList();
	}

}
