package br.com.puchero.dao.impl;

import javax.persistence.EntityManager;

import br.com.puchero.dao.PutaDAO;
import br.com.puchero.model.Puta;

public class PutaDAOImpl extends GenericoDAOImpl<Puta, Integer> implements PutaDAO {

	public PutaDAOImpl(EntityManager em) {
		super(em);
	}

}
