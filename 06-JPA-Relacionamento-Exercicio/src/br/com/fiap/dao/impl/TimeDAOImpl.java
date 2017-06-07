package br.com.fiap.dao.impl;

import br.com.fiap.entity.Time;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TimeDAO;

public class TimeDAOImpl 
				extends GenericDAOImpl<Time, Integer>
										implements TimeDAO {

	public TimeDAOImpl(EntityManager em) {
		super(em);
	}

}