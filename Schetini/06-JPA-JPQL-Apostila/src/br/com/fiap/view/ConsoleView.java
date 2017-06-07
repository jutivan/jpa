package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class ConsoleView {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		PacoteDAOImpl pacoteDAOImpl = new PacoteDAOImpl(em);
		List<Pacote> pacotes = pacoteDAOImpl.listar();
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getPreco()));
		
		List<Pacote> busca = pacoteDAOImpl.buscarPorPreco(2000, 7000);
		busca.forEach(p -> System.out.println(p.getDescricao() + " " + p.getPreco()));
		
		
		ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl(em);
		List<Cliente> clientes = clienteDAOImpl.listar();
		clientes.forEach(p -> System.out.println(p.getCpf() + " " + p.getNome()));
		
		TransporteDAOImpl transporteDAOImpl = new TransporteDAOImpl(em);
		Transporte transporte = transporteDAOImpl.pesquisar(1);
		
		List<Pacote> buscarPorTransporte = pacoteDAOImpl.buscarPorTransporte(transporte);
		buscarPorTransporte.forEach(p -> System.out.println(p.getDescricao() + " " + p.getPreco()));
		
		CidadeDAO cidadeDAOImpl = new CidadeDAOImpl(em);
		Cidade cidade = cidadeDAOImpl.pesquisar(2);
		List<Cliente> buscarPorCidade = clienteDAOImpl.buscarPorCidade(cidade);
		buscarPorCidade.forEach(p -> System.out.println(p.getCpf() + " " + p.getNome()));
		
		
		System.out.println("===== BUSCANDO POR DATA ===========");
		Calendar dtReseva1 = Calendar.getInstance();
		dtReseva1.set(2017, 1, 1);
		Calendar dtReseva2 = Calendar.getInstance();
		dtReseva2.set(2017, 10, 10);
		ReservaDAOImpl reservaDAOImpl = new ReservaDAOImpl(em);
		List<Cliente> buscarPorPeriodoDeReserva = reservaDAOImpl.buscarPorPeriodoDeReserva(dtReseva1, dtReseva2);
		buscarPorPeriodoDeReserva.forEach(p -> System.out.println(p.getCpf() + " " + p.getNome()));
		
		
		System.out.println("===== BUSCANDO POR DIA DE RESERVA ===========");
		List<Cliente> buscarPorDiaReserva = clienteDAOImpl.buscarPorDiaReserva(10);
		buscarPorDiaReserva.forEach(p -> System.out.println(p.getCpf() + " " + p.getNome()));
		
		
		System.out.println("===== BUSCANDO POR DATA DE SAIDA ===========");
		List<Pacote> buscarPorDatas = pacoteDAOImpl.buscarPorDatas(new GregorianCalendar(2017, 1, 1), new GregorianCalendar(2017, 12, 30));
		buscarPorDatas.forEach(p -> System.out.println(p.getDescricao() + " " + p.getPreco()));
		
		System.out.println("===== BUSCANDO CLIENTE POR NOME E CIDADE ===========");
		List<Cliente> buscarPorNomeCidade = clienteDAOImpl.buscarPorNomeCidade("Leandro", "Londrina");
		buscarPorNomeCidade.forEach(p -> System.out.println(p.getCpf() + " " + p.getNome()));
		
		em.close();
		System.exit(0);
	}

}
