package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Medico;

public interface MedicoDAO 
			extends GenericDAO<Medico, Integer>{
	
	List<Medico> buscarPorNome(String nome);
	
	List<Medico> buscarPorEspecialidade(String nome);

}
