package br.com.puchero.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.puchero.dao.GenericoDAO;
import br.com.puchero.exception.IdNaoEncontradoException;
import br.com.puchero.exception.TransacaoException;

public abstract class GenericoDAOImpl<E, K> implements GenericoDAO<E, K> {

	private EntityManager em;
	private Class<E> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericoDAOImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void inserir(E e) {
		em.persist(e);
	}

	@Override
	public void remover(K id) throws IdNaoEncontradoException {
		E e = buscar(id);
		if(e == null)
			throw new IdNaoEncontradoException();
		em.remove(e);
	}

	@Override
	public void alterar(E e) {
		em.merge(e);
	}

	@Override
	public E buscar(K id) {
		return em.find(clazz, id);
	}

	@Override
	public void efectivarTransacao() throws TransacaoException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw new TransacaoException();
		}
		em.close();
	}
	
}
