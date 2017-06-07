package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PessoaFisicaDAO;
import br.com.fiap.entity.PessoaFisica;

public class PessoaFisicaDAOImpl 
				extends GenericDAOImpl<PessoaFisica, Integer>
										implements PessoaFisicaDAO{

	public PessoaFisicaDAOImpl(EntityManager em) {
		super(em);
	}

}