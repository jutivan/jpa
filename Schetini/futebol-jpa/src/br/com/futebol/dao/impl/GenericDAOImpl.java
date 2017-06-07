package br.com.futebol.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.futebol.dao.GenericDAO;
import br.com.futebol.exception.CommitErrorException;
import br.com.futebol.exception.IdNotFoundException;

public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	private EntityManager manager;
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager manager) {
		this.manager = manager;
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void create(T entidade) {
		manager.persist(entidade);
	}

	public void update(T entidade) {
		manager.merge(entidade);
	}

	public T find(K id) {
		return manager.find(clazz, id);
	}

	public void delete(K id) throws IdNotFoundException {
		T obj = find(id);
		if(obj == null)
			throw new IdNotFoundException();
		manager.remove(obj);
	}

	public void commit() throws CommitErrorException {
		try {
			manager.getTransaction().begin();
			manager.getTransaction().commit();
		} catch (Exception e) {
			if(manager.getTransaction().isActive())
				manager.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitErrorException();
		}
		manager.close();
	}
}
