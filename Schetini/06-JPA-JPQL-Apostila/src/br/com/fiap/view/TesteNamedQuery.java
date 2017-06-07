package br.com.fiap.view;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;

public class TesteNamedQuery {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ClienteDAO clienteDAO = new ClienteDAOImpl(em);
		
		Cliente cliente = clienteDAO.buscarPorCpf("90028383848");
		System.out.println("Sucesso: " + cliente.getNome());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Cliente> aniversariantes = clienteDAO.buscarPorDataNascimento(8);
		aniversariantes.forEach(a -> 
			System.out.println(a.getNome() + " " + a.getCpf() + " " + sdf.format(a.getDataNascimento().getTime()))
		);
		
		CidadeDAOImpl cidadeDAO = new CidadeDAOImpl(em);
		List<Cidade> cidades = cidadeDAO.buscarPorEstado("SP");
		cidades.forEach(c -> System.out.println(c.getNome()));
	}
	
}
