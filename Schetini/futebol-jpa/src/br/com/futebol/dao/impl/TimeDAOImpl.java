package br.com.futebol.dao.impl;

import javax.persistence.EntityManager;

import br.com.futebol.dao.TimeDAO;
import br.com.futebol.model.Time;

public class TimeDAOImpl extends GenericDAOImpl<Time, Integer> implements TimeDAO {

	public TimeDAOImpl(EntityManager manager) {
		super(manager);
	}

}
