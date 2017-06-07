package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Especialidade;
import br.com.fiap.entity.Medico;

public interface MedicoDAO extends GenericDAO<Medico, Integer> {
	List<Medico> buscaPeloNome(String nome);
	List<Medico> buscaPorNomeEspecialidade(String nome);
	List<Medico> buscaPorEspecialidade(Especialidade especialidade);
}
