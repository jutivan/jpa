package com.livraria.dao;

import java.util.List;

import com.livraria.models.Autor;

public interface AutorDAO extends GenericDAO<Autor, Integer> {
	
	List<Autor> buscaPeloNome(String nome);
	
}
