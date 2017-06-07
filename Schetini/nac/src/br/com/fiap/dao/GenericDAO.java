package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;

public interface GenericDAO<E, K> {

	E buscar(K id);
	
	void inserir(E entidade);
	
	void atualizar(E entidade);
	
	void remover(K id) throws IdNaoEncontradoException;
	
	void salvar() throws CommitException;
	
}
