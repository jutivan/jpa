package com.livraria.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.livraria.dao.AutorDAO;
import com.livraria.models.Autor;


public class AutorDAOImpl extends GenericDAOImpl<Autor, Integer> implements AutorDAO {

	public AutorDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Autor> buscaPeloNome(String nome) {
		TypedQuery<Autor> query = getEntityManager().createQuery("from Autor a where a.nome like :nome", Autor.class);
		query.setParameter("nome", nome);
		return query.getResultList();
	}

}
