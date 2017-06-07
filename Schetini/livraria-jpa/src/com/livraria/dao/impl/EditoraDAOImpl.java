package com.livraria.dao.impl;

import javax.persistence.EntityManager;

import com.livraria.dao.EditoraDAO;
import com.livraria.models.Editora;

public class EditoraDAOImpl extends GenericDAOImpl<Editora, Integer> implements EditoraDAO {

	public EditoraDAOImpl(EntityManager em) {
		super(em);
	}

}
