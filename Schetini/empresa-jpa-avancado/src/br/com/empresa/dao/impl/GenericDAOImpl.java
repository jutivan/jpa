package br.com.empresa.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.empresa.dao.GenericDAO;
import br.com.empresa.exception.CommitErrorException;
import br.com.empresa.exception.IdNotFoundException;

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		clazz = (Class<T>) ((ParameterizedType) 
				getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.em = em;
	}
	
	public void create(T entidade) {
		em.persist(entidade);
	}

	public void commit() throws CommitErrorException {
		try{
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitErrorException();
		}
	}

	public void update(T entidade) {
		em.merge(entidade);
	}

	public T find(K id) {
		return em.find(clazz, id);
	}

	public void delete(K id) throws IdNotFoundException {
		T entidade = find(id);
		if (entidade == null){
			throw new IdNotFoundException("Entidade não encontrada");
		}
		em.remove(entidade);
	}

	
	
}
