package br.com.futebol.teste;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.futebol.dao.impl.CampeonatoDAOImpl;
import br.com.futebol.exception.CommitErrorException;
import br.com.futebol.model.Campeonato;
import br.com.futebol.model.Jogador;
import br.com.futebol.model.Tecnico;
import br.com.futebol.model.Time;
import br.com.futebol.singleton.EntityManagerFactorySingleton;

public class CascadeTudo {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		CampeonatoDAOImpl campeonatoDAO = new CampeonatoDAOImpl(em);
		
		Time unidos = new Time("Unidos", new GregorianCalendar(1987, 11, 23), 3);
		unidos.addJogador(new Jogador("Thiago"));
		unidos.addJogador(new Jogador("Robertison"));
		unidos.addJogador(new Jogador("Neilson"));
		unidos.addTecnico(new Tecnico("Jadildson"));
		
		Time patetas = new Time("Patetas", new GregorianCalendar(1999, 2, 12), 2);
		patetas.addJogador(new Jogador("Denildson"));
		patetas.addJogador(new Jogador("Patetas"));
		patetas.addJogador(new Jogador("Meilson"));
		patetas.addTecnico(new Tecnico("Kleberson"));
		
		Campeonato nada = new Campeonato("Copa de Nada");
		Campeonato america = new Campeonato("Copa America");
		
		nada.addTime(patetas);
		nada.addTime(unidos);
		america.addTime(patetas);
		america.addTime(unidos);
		
		campeonatoDAO.create(america);
		campeonatoDAO.create(nada);
		
		try {
			campeonatoDAO.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
		}
	}
	
}
