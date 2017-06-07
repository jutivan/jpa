package com.livraria.dao;

import java.util.List;

import com.livraria.models.Exemplar;
import com.livraria.models.Livro;

public interface ExemplarDAO extends GenericDAO<Exemplar, Integer>{

	List<Exemplar> buscarPorLivro(Livro livro);
	
}
