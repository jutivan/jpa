package br.com.fiap.teste;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.PessoaFisicaDAOImpl;
import br.com.fiap.dao.impl.PessoaJuridicaDAOImpl;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.PessoaFisica;
import br.com.fiap.model.PessoaJuridica;
import br.com.fiap.model.Sexo;

public class Teste {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		PessoaJuridicaDAOImpl pjDAO = new PessoaJuridicaDAOImpl(em);
		PessoaFisicaDAOImpl pfDAO = new PessoaFisicaDAOImpl(em);
		
		pjDAO.cadastrar(new PessoaJuridica("Robson", "robson@empresa.com.br", "1234567"	, "Robson Cosmeticos"));
		try {
			pjDAO.salvar();
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		pfDAO.cadastrar(new PessoaFisica("Poliana", "polly@cataz.com.br", "341341555", Sexo.FEMININO));
		try {
			pfDAO.salvar();
		} catch (DBException e) {
			e.printStackTrace();
		}

		em.close();
	}
	
}
