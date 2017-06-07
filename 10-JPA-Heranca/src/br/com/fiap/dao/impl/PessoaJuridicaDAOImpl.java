package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PessoaJuridicaDAO;
import br.com.fiap.entity.PessoaJuridica;

public class PessoaJuridicaDAOImpl 
					extends GenericDAOImpl<PessoaJuridica, Integer>
								implements PessoaJuridicaDAO{

	public PessoaJuridicaDAOImpl(EntityManager em) {
		super(em);
	}

}