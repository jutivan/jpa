package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva,Integer>{

	List<Cliente> buscarPorPeriodoDeReserva(Calendar inicio, Calendar fim);
	
}
