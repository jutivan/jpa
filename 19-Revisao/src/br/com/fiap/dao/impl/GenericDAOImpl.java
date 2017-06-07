package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.exception.IdNotFoundException;

public abstract class GenericDAOImpl<T,K> 
					implements GenericDAO<T, K>{

	protected EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		clazz = (Class<T>) ((ParameterizedType) 
				getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.em = em;
	}
	
	@Override
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

	@Override
	public void update(T entidade) {
		em.merge(entidade);
	}

	@Override
	public T find(K id) {
		return em.find(clazz, id);
	}

	@Override
	public void delete(K id) throws IdNotFoundException {
		T entidade = find(id);
		if (entidade == null){
			throw new IdNotFoundException("Entidade não encontrada");
		}
		em.remove(entidade);
	}

	
	
}
