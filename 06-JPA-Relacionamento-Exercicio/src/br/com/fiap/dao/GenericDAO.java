package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public interface GenericDAO<T,K> {

	void cadastrar(T entidade);
	void atualizar(T entidade);
	void apagar(K chave) throws IdNotFoundException;
	T buscar(K chave);
	void salvar() throws CommitException; //commit
	
}