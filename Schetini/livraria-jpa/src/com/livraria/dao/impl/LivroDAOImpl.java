package com.livraria.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.livraria.dao.LivroDAO;
import com.livraria.models.Livro;

public class LivroDAOImpl extends GenericDAOImpl<Livro, Integer> implements LivroDAO {

	public LivroDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Livro> buscaTodosComLimite(int limite) {
		return getEntityManager()
				.createQuery("from Livro", Livro.class).setMaxResults(limite).getResultList();
	}

	@Override
	public List<Livro> buscaPorTitulo(String titulo) {
		TypedQuery<Livro> query = getEntityManager()
				.createQuery("from Livro l where l.titulo = :titulo", Livro.class);
		query.setParameter("titulo", titulo);
		return query.getResultList();
	}

	@Override
	public List<Livro> buscarPelaEditora(String nome) {
		TypedQuery<Livro> query = getEntityManager()
				.createQuery("from Livro l where l.editora.nome = :nome", Livro.class);
		query.setParameter("nome", nome);
		return query.getResultList();
	}

}
