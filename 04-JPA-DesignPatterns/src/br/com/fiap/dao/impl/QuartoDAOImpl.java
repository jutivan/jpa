package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.dao.QuartoDAO;
import br.com.fiap.entity.Quarto;

public class QuartoDAOImpl 
			extends GenericDAOImpl<Quarto, Integer>
					implements QuartoDAO {

	public QuartoDAOImpl(EntityManager em) {
		super(em);
	}

}