package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.IdNotFoundException;

public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	private EntityManager manager;
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager manager) {
		this.manager = manager;
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void create(T entidade) {
		manager.persist(entidade);
	}

	@Override
	public void update(T entidade) {
		manager.merge(entidade);
	}

	@Override
	public T find(K id) {
		return manager.find(clazz, id);
	}

	@Override
	public void delete(K id) throws IdNotFoundException {
		T obj = find(id);
		if(obj == null)
			throw new IdNotFoundException();
		manager.remove(obj);
	}

	@Override
	public void commit() throws CommitException {
		try {
			manager.getTransaction().begin();
			manager.getTransaction().commit();
		} catch (Exception e) {
			if(manager.getTransaction().isActive())
				manager.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
		manager.close();
	}
}
