package com.livraria.dao;

import java.util.List;

import com.livraria.models.Livro;

public interface LivroDAO extends GenericDAO<Livro, Integer> {

	List<Livro> buscaTodosComLimite(int limite);
	
	List<Livro> buscaPorTitulo(String titulo);
	
	List<Livro> buscarPelaEditora(String nome);
	
}
