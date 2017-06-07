package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoDAO;
import br.com.fiap.model.Grupo;

public class GrupoDAOImpl extends GenericDAOImpl<Grupo, Integer> implements GrupoDAO {

	public GrupoDAOImpl(EntityManager em) {
		super(em);
	}

}
