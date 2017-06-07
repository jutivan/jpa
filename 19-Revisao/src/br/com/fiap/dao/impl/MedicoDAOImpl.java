package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.entity.Medico;

public class MedicoDAOImpl 
				extends GenericDAOImpl<Medico, Integer>
											implements MedicoDAO{

	public MedicoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Medico> buscarPorNome(String nome) {
		return em.createQuery("from Medico m where m.nome like :n",
				Medico.class).setParameter("n", "%"+nome+"%")
				.getResultList();
	}

	@Override
	public List<Medico> buscarPorEspecialidade(String nome) {
		return em.createQuery("from Medico m inner join m.especialidades e where e.nome like :n",
				Medico.class).setParameter("n", "%"+nome+"%")
				.getResultList();
	}

}
