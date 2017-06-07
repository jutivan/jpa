package com.livraria.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import com.livraria.dao.GenericDAO;
import com.livraria.exceptions.CommitException;
import com.livraria.exceptions.IdNaoEncontradoException;

public abstract class GenericDAOImpl<E extends Serializable, K> implements GenericDAO<E, K> {

	private EntityManager em;
	
	private final Class<E> clazz;
	
	@SuppressWarnings("unchecked")
	protected GenericDAOImpl(EntityManager em) {
		clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.em = em;
	}
	
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public E buscar(K id) {
		return em.find(clazz, id);
	}

	@Override
	public void inserir(E entidade) {
		em.persist(entidade);
	}

	@Override
	public void atualizar(E entidade) {
		em.merge(entidade);
	}

	@Override
	public void remover(K id) throws IdNaoEncontradoException {
		E entidade = buscar(id);
		if(entidade == null) 
			throw new IdNaoEncontradoException();
		em.remove(entidade);
	}

	@Override
	public void salvar() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
	}

}
