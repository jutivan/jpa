package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;

public interface GenericDAO<T,K> {

	void cadastrar(T entidade);
	void alterar(T entidade);
	T pesquisar(K id);
	void remover(K id) throws IdNotFoundException;
	public List<T> listar();
	void salvar() throws DBException;
}
