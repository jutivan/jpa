package br.com.futebol.dao.impl;

import javax.persistence.EntityManager;

import br.com.futebol.dao.TecnicoDAO;
import br.com.futebol.model.Tecnico;

public class TecnicoDAOImpl extends GenericDAOImpl<Tecnico, Integer> implements TecnicoDAO{

	public TecnicoDAOImpl(EntityManager manager) {
		super(manager);
	}

}
