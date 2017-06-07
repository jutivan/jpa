package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	Cliente buscarPorCpf(String cpf);
	
	List<Cliente> buscarPorDataNascimento(int mes);

	List<Cliente> buscarPorCidade(Cidade cidade);

	List<Cliente> buscarPorDiaReserva(int reserva);
	
	List<Cliente> buscarPorNomeCidade(String nome, String cidade);
	
	long qtdClientes();
	
	long qtdClientesPorEstado(String estado);

}
