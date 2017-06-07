package br.com.futebol.dao.impl;

import javax.persistence.EntityManager;

import br.com.futebol.dao.CampeonatoDAO;
import br.com.futebol.model.Campeonato;

public class CampeonatoDAOImpl extends GenericDAOImpl<Campeonato, Integer> implements CampeonatoDAO {

	public CampeonatoDAOImpl(EntityManager manager) {
		super(manager);
	}

}
