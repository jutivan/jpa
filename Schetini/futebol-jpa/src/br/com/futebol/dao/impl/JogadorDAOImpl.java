package br.com.futebol.dao.impl;

import javax.persistence.EntityManager;

import br.com.futebol.dao.JogadorDAO;
import br.com.futebol.model.Jogador;

public class JogadorDAOImpl extends GenericDAOImpl<Jogador, Integer> implements JogadorDAO {

	public JogadorDAOImpl(EntityManager manager) {
		super(manager);
	}

}
