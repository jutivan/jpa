package br.com.empresa.dao;

import br.com.empresa.exception.CommitErrorException;
import br.com.empresa.exception.IdNotFoundException;

public interface GenericDAO<T,K> {

	void create(T entidade);
	void update(T entidade);
	T find(K id);
	void delete(K id) throws IdNotFoundException;
	void commit() throws CommitErrorException;
}
