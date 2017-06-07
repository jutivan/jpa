package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entidades.Editora;
import br.com.fiap.entidades.Livro;

public interface LivroDAO extends GenericDAO<Livro, Integer> {	
	List<Livro> buscaPeloTitulo(String titulo);
	long contarLivrosPelaEditora(Editora editora);
	List<Livro> buscarPeloNomeDaEditora(String nome);
}
