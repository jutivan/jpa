package br.com.puchero.dao;

import br.com.puchero.exception.IdNaoEncontradoException;
import br.com.puchero.exception.TransacaoException;

public interface GenericoDAO<E, K> {

	void inserir(E e);
	
	void remover(K id) throws IdNaoEncontradoException;
	
	void alterar(E e);
	
	E buscar(K id);
	
	void efectivarTransacao() throws TransacaoException;
}
