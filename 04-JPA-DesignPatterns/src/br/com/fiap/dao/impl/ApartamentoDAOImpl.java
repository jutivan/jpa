package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ApartamentoDAO;
import br.com.fiap.entity.Apartamento;

public class ApartamentoDAOImpl
	extends GenericDAOImpl<Apartamento, Integer>
						implements ApartamentoDAO{

	public ApartamentoDAOImpl(EntityManager em) {
		super(em);
	}
	
}
