package br.com.futebol.dao;

import br.com.futebol.exception.CommitErrorException;
import br.com.futebol.exception.IdNotFoundException;

public interface GenericDAO<T,K> {

	void create(T entidade);
	void update(T entidade);
	T find(K id);
	void delete(K id) throws IdNotFoundException;
	void commit() throws CommitErrorException;
}
