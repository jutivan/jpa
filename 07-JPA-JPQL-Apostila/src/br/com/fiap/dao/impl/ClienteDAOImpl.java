package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> buscarPorEstado(String estado) {
		TypedQuery<Cliente> query = em.createQuery(
			"from Cliente c where c.endereco.cidade.uf = "
			+ ":est",Cliente.class);
		query.setParameter("est", estado);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiaReserva(int reserva) {
		TypedQuery<Cliente> query = em.createQuery(
			"select r.cliente from Reserva r "
			+ "where r.numeroDias = :n",
			Cliente.class);
		
		query.setParameter("n", reserva);
		query.setMaxResults(100);//Máximo de resultados
		
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		return em.createQuery("from Cliente c where c.nome "
			+ "like :n and c.endereco.cidade.nome like :c",Cliente.class)
			.setParameter("n", "%" + nome + "%")
			.setParameter("c", "%" + cidade + "%")
			.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstados(List<String> estados) {
		return em.createQuery("from Cliente c where "
				+ "c.endereco.cidade.uf in :estados",Cliente.class)
				.setParameter("estados", estados)
				.setMaxResults(50)
				.getResultList();
	}

	@Override
	public long buscarQuantidade() {
		return em.createQuery(
			"select count(c) from Cliente c",Long.class)
			.getSingleResult();
	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		return em.createNamedQuery(
				"Cliente.porCpf",Cliente.class)
				.setParameter("cpf", cpf)
				.getSingleResult();
	}

	@Override
	public List<Cliente> buscarPorMesAniversario(int mes) {
		return em.createNamedQuery(
				"Cliente.porMesNascimento",Cliente.class)
				.setParameter("mes", mes)
				.getResultList();
	}

}





