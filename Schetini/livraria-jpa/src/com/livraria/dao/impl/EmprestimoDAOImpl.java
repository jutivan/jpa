package com.livraria.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.livraria.dao.EmprestimoDAO;
import com.livraria.models.Emprestimo;
import com.livraria.models.Usuario;

public class EmprestimoDAOImpl extends GenericDAOImpl<Emprestimo, Integer> implements EmprestimoDAO {

	public EmprestimoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public long buscaQtdPorUsuario(Usuario usuario) {
		TypedQuery<Long> query = getEntityManager()
				.createQuery("select count(id) from Emprestimo e where e.usuario = :usuario", Long.class);
		query.setParameter("usuario", usuario);
		return query.getSingleResult();
	}

	@Override
	public List<Emprestimo> buscaComDataEmprestimoEntre(Calendar inicio, Calendar fim) {
		TypedQuery<Emprestimo> query = getEntityManager()
				.createQuery("from Emprestimo e where e.dataEmprestimo between :inicio and :fim", Emprestimo.class);
		query.setParameter("inicio", inicio);
		query.setParameter("fim", fim);
		return query.getResultList();
	}

}
