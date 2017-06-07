package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.entity.Especialidade;
import br.com.fiap.entity.Medico;

public class MedicoDAOImpl extends GenericDAOImpl<Medico, Integer> implements MedicoDAO {

	public MedicoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Medico> buscaPeloNome(String nome) {
		return em.createQuery(
				"from Medico m where m.nome like :nome",
				Medico.class
		).setParameter("nome", "%" + nome + "%")
		 .getResultList();
	}

	@Override
	public List<Medico> buscaPorNomeEspecialidade(String nome) {
		return em.createQuery(
				"select m from Medico m inner join m.especialidades e where e.nome like :nome",
				Medico.class
		).setParameter("nome", nome)
		.getResultList();
	}

	@Override
	public List<Medico> buscaPorEspecialidade(Especialidade especialidade) {
		return em.createQuery(
				"select m from Medico m inner join m.especialidades e where e = :especialidade",
				Medico.class
		).setParameter("especialidade", especialidade)
		.getResultList();
	}
}
