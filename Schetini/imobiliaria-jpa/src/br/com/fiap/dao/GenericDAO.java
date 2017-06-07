package br.com.fiap.dao;

import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.IdNotFoundException;

public interface GenericDAO<T, K> {

	void create(T entidade);
	void update(T entidade);
	T find(K id);
	void delete(K id) throws IdNotFoundException;
	void commit() throws CommitException;
	
}
