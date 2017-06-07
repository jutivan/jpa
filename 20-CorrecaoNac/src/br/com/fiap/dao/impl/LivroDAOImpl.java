package br.com.fiap.dao.impl;

import br.com.fiap.entity.Editora;
import br.com.fiap.entity.Livro;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.fiap.dao.LivroDAO;

public class LivroDAOImpl 
				extends GenericDAOImpl<Livro, String>
							implements LivroDAO{

	public LivroDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Livro> buscarPorTitulo(String titulo) {
		return em.createQuery("from Livro l where "
				+ "l.titulo like :t",Livro.class)
				.setParameter("t", "%" + titulo + "%")
				.setMaxResults(50)
				.getResultList();
	}

	@Override
	public long contarQuantidade(Editora editora) {
		return em.createQuery("select count(l) from "
				+ "Livro l where l.editora = :e",Long.class)
				.setParameter("e",editora)
				.getSingleResult();
	}

	@Override
	public List<Livro> buscarPorEditora(String editora) {
		return em.createQuery("from Livro l where "
				+ "l.editora.nome like :n",Livro.class)
				.setParameter("n", editora)
				.getResultList();
	}

}




