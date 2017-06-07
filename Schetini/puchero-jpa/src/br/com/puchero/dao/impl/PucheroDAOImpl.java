package br.com.puchero.dao.impl;

import javax.persistence.EntityManager;

import br.com.puchero.dao.PucheroDAO;
import br.com.puchero.model.Puchero;

public class PucheroDAOImpl extends GenericoDAOImpl<Puchero, Integer> implements PucheroDAO {

	public PucheroDAOImpl(EntityManager em) {
		super(em);
	}

}
