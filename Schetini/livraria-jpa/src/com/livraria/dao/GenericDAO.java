package com.livraria.dao;

import java.io.Serializable;

import com.livraria.exceptions.CommitException;
import com.livraria.exceptions.IdNaoEncontradoException;

public interface GenericDAO<E extends Serializable, K> {

	E buscar(K id);
	
	void inserir(E entidade);
	
	void atualizar(E entidade);
	
	void remover(K id) throws IdNaoEncontradoException;
	
	void salvar() throws CommitException;
	
}
