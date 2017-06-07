package com.livraria.dao;

import java.util.Calendar;
import java.util.List;

import com.livraria.models.Emprestimo;
import com.livraria.models.Usuario;

public interface EmprestimoDAO extends GenericDAO<Emprestimo, Integer>{

	long buscaQtdPorUsuario(Usuario usuario);
	
	List<Emprestimo> buscaComDataEmprestimoEntre(Calendar inicio, Calendar fim);
	
}
