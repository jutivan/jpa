package com.livraria.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.livraria.dao.ExemplarDAO;
import com.livraria.models.Exemplar;
import com.livraria.models.Livro;

public class ExemplarDAOImpl extends GenericDAOImpl<Exemplar, Integer> implements ExemplarDAO {

	public ExemplarDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Exemplar> buscarPorLivro(Livro livro) {
		TypedQuery<Exemplar> query = getEntityManager()
				.createQuery("from Exemplar e where e.livro = :livro", Exemplar.class);
		query.setParameter("livro", livro);
		return query.getResultList();
	}
	
}
