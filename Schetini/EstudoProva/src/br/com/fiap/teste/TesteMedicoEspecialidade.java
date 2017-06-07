package br.com.fiap.teste;

import java.time.Month;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.MedicoDAOImpl;
import br.com.fiap.entity.Especialidade;
import br.com.fiap.entity.Medico;
import br.com.fiap.entity.Sexo;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class TesteMedicoEspecialidade {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		MedicoDAOImpl medicoDAO = new MedicoDAOImpl(em);
		
		Especialidade otorrino = new Especialidade("Otorrino", "Cuida de nariz, orelha e garganta");
		Especialidade pediatra = new Especialidade("Pediatra", "trata de criancas");
		List<Especialidade> especialidades1 = new ArrayList<>();
		especialidades1.add(otorrino);
		especialidades1.add(pediatra);
		
		Especialidade cardiologista = new Especialidade("Cardiologista", "cuida do coracao");
		List<Especialidade> especialidades2 = new ArrayList<>();
		especialidades2.add(cardiologista);
		
		Medico suzano = new Medico(
				"Suzano",
				new GregorianCalendar(1993, Month.AUGUST.getValue(), 12), 
				null, 
				Sexo.MASCULINO, 
				especialidades1
		);
		medicoDAO.cadastrar(suzano);
		try {
			medicoDAO.salvar();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro");
		}
		
		Medico aristoteles = new Medico(
				"Aristoteles", 
				new GregorianCalendar(1995, Month.APRIL.getValue(), 23), 
				null, 
				Sexo.MASCULINO, 
				especialidades2
		);
		medicoDAO.cadastrar(aristoteles);
		try {
			medicoDAO.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			System.out.println("Erro");
		}
		
		Medico romano = new Medico(
				"Romano",
				new GregorianCalendar(1988, Month.FEBRUARY.getValue(), 23), 
				null, 
				Sexo.MASCULINO, 
				especialidades1
		);
		medicoDAO.cadastrar(romano);
		try {
			medicoDAO.salvar();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro");
		}
		
		em.close();
	}
	
}
