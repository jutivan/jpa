package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> buscarPorPeriodoDeReserva(Calendar inicio, Calendar fim) {
		TypedQuery<Cliente> query = em.createQuery(
				"select cliente from Reserva r where r.dataReserva between :inicio and :fim", 
				Cliente.class
				);
		query.setParameter("inicio", inicio);
		query.setParameter("fim", fim);
		return query.getResultList();
	}

}
