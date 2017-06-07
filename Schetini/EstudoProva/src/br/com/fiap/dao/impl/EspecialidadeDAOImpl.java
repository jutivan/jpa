package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EspecialidadeDAO;
import br.com.fiap.entity.Especialidade;

public class EspecialidadeDAOImpl extends GenericDAOImpl<Especialidade, Integer> implements EspecialidadeDAO {

	public EspecialidadeDAOImpl(EntityManager em) {
		super(em);
	}
}
