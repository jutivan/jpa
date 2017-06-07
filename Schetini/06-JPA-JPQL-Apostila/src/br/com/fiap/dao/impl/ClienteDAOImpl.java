package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> buscarPorCidade(Cidade cidade) {
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.endereco.cidade = :cidade", Cliente.class);
		return query.setParameter("cidade", cidade).getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiaReserva(int reserva) {
		TypedQuery<Cliente> query = em.createQuery("select r.cliente from Reserva r where r.numeroDias = :n", Cliente.class);
		query.setParameter("n", reserva);
		query.setMaxResults(100);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorNomeCidade(String nome, String cidade) {
		return em.createQuery(
				"from Cliente c where c.nome like :nome and c.endereco.cidade.nome like :cidade", Cliente.class)
				.setParameter("nome", nome)
				.setParameter("cidade", cidade)
				.getResultList();
	}

	@Override
	public long qtdClientes() {
		return em.createQuery("select count(id) from Cliente", Long.class).getSingleResult();
	}

	@Override
	public long qtdClientesPorEstado(String estado) {
		return em.createQuery("select count(c) from Cliente c where c.endereco.cidade.uf like :e", Long.class)
				.setParameter("e", "%" + estado + "%")
				.getSingleResult();
	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		return em.createNamedQuery("Cliente.porCpf", Cliente.class)
				.setParameter("cpf", cpf)
				.getSingleResult();
	}

	@Override
	public List<Cliente> buscarPorDataNascimento(int mes) {
		return em.createNamedQuery("Cliente.porMesNascimento", Cliente.class)
				.setParameter("mes", mes)
				.getResultList();
	}

}
