package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> buscarPorPreco(float minimo, float maximo) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote c where c.preco between :minimo and :maximo", Pacote.class);
		query.setParameter("minimo", minimo);
		query.setParameter("maximo", maximo);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.transporte = :transporte", Pacote.class);
		query.setParameter("transporte", transporte);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.dataSaida between :inicio and :fim", Pacote.class);
		query.setParameter("inicio", inicio);
		query.setParameter("fim", fim);
		return query.getResultList();
	}
	
	@Override
	public double precoMedioDosPacotes() {
		return em.createQuery("select avg(preco) from Pacote", Double.class).getSingleResult();
	}

	@Override
	public long quantidadeSaidaEntre(Calendar inicio, Calendar fim) {
		return em.createQuery("select count(id) from Pacote p where p.dataSaida between :inicio and :fim", Long.class)
				.setParameter("inicio", inicio)
				.setParameter("fim", fim)
				.getSingleResult();
	}

	@Override
	public List<Pacote> buscarMaiorPreco() {
		return em.createQuery("select p from Pacote p where p.preco = (select max(p.preco) from Pacote p)", Pacote.class)
				.getResultList();
	}
}
