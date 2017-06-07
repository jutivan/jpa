package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	protected EntityManager em;
	
	//.class da entidade (usado na busca)
	private Class<T> clazz;
	
	//Construtor
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType)getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void cadastrar(T entity) {
		em.persist(entity);
	}

	public void alterar(T entity) {
		em.merge(entity);
	}

	public void remover(K codigo) throws IdNotFoundException {
		T entidade = pesquisar(codigo);
		if (entidade == null){
			throw new IdNotFoundException("Entidade não encontrada");
		}
		em.remove(entidade);
	}

	public T pesquisar(K codigo) {
		return em.find(clazz, codigo);
	}
	
	public void salvar() throws DBException{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new DBException("Erro no commit", e);
		}
	}

	public List<T> listar() {
		TypedQuery<T> query = em.createQuery("from " + clazz.getName(), clazz);
		return query.getResultList();
	}

}
