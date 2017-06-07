package br.com.fiap.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.EspecialidadeDAOImpl;
import br.com.fiap.dao.impl.MedicoDAOImpl;
import br.com.fiap.entity.Especialidade;
import br.com.fiap.entity.Medico;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class TesteBuscaJPQL {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		MedicoDAOImpl medicoDAO = new MedicoDAOImpl(em);
		EspecialidadeDAOImpl especialidadeDAO = new EspecialidadeDAOImpl(em);
		
		List<Medico> lista = medicoDAO.buscaPeloNome("Aristoteles");
		lista.forEach(i -> System.out.println(i.getNome() + " " + i.getDataNascimento() + " " + i.getSexo()));
		
		
		List<Medico> lista2 = medicoDAO.buscaPorNomeEspecialidade("Otorrino");
		lista2.forEach(i -> System.out.println(i.getNome() + " " + i.getDataNascimento() + " " + i.getSexo()));
		
		Especialidade especialidade = especialidadeDAO.pesquisar(1);
		List<Medico> lista3 = medicoDAO.buscaPorEspecialidade(especialidade);
		lista3.forEach(i -> System.out.println(i.getNome() + " " + i.getDataNascimento() + " " + i.getSexo()));
	}
	
}
