package com.livraria.dao.impl;

import javax.persistence.EntityManager;

import com.livraria.dao.UsuarioDAO;
import com.livraria.models.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO {

	public UsuarioDAOImpl(EntityManager em) {
		super(em);
	}

}
