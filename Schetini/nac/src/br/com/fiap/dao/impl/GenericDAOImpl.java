package br.com.fiap.dao.impl;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;

public class GenericDAOImpl<E, K> implements GenericDAO<E, K>{

	private EntityManager em;
	private Class<E> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
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
		E entity = em.find(clazz, id);
		if(entity == null)
			throw new IdNaoEncontradoException();
		em.remove(entity);
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
