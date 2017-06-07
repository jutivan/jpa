package br.com.fiap.dao;

import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.exception.IdNotFoundException;

public interface GenericDAO<T,K> {

	void create(T entidade);
	void update(T entidade);
	T find(K id);
	void delete(K id) throws IdNotFoundException;
	void commit() throws CommitErrorException;
}
