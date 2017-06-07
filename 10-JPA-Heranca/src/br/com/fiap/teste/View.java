package br.com.fiap.teste;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PessoaFisicaDAO;
import br.com.fiap.dao.PessoaJuridicaDAO;
import br.com.fiap.dao.impl.PessoaFisicaDAOImpl;
import br.com.fiap.dao.impl.PessoaJuridicaDAOImpl;
import br.com.fiap.entity.PessoaFisica;
import br.com.fiap.entity.PessoaJuridica;
import br.com.fiap.entity.Sexo;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		//Cadastrar uma PF e PJ
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		PessoaFisicaDAO pfDao = new PessoaFisicaDAOImpl(em);
		PessoaJuridicaDAO pjDao = new PessoaJuridicaDAOImpl(em);
		
		PessoaFisica pf = new PessoaFisica("Fernanda", 
				"fernanda@fernanda.com", "132131313", Sexo.FEMININO);
		
		PessoaJuridica pj = new PessoaJuridica("Banco Bra",
				"bradesco@bb.com","123131313/001-54","Bradesco");
		
		try {
			pfDao.create(pf);
			pjDao.create(pj);
			pjDao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}
		
		em.close();
		System.exit(0);
	}
	
}
