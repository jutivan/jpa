package br.com.puchero.dao.impl;

import javax.persistence.EntityManager;

import br.com.puchero.dao.CafetinaDAO;
import br.com.puchero.model.Cafetina;

public class CafetinaDAOImpl extends GenericoDAOImpl<Cafetina, Integer> implements CafetinaDAO {

	public CafetinaDAOImpl(EntityManager em) {
		super(em);
	}

}
