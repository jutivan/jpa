package br.com.empresa.dao.impl;

import javax.persistence.EntityManager;

import br.com.empresa.dao.DependenteDAO;
import br.com.empresa.model.Dependente;

public class DependenteDAOImpl extends GenericDAOImpl<Dependente, Integer> implements DependenteDAO{

	public DependenteDAOImpl(EntityManager em) {
		super(em);
	}
}
