package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ContaPoupancaDAO;
import br.com.fiap.model.ContaPoupanca;

public class ContaPoupancaDAOImpl extends GenericDAOImpl<ContaPoupanca, Integer> implements ContaPoupancaDAO {

	public ContaPoupancaDAOImpl(EntityManager em) {
		super(em);
	}
}
