package br.com.empresa.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="emp_funcionario")
@SecondaryTable(name="emp_dado_funcionario")
@SequenceGenerator(name="seqFuncionario", sequenceName="sq_emp_funcionario", allocationSize=1)
public class Funcionario {

	@Id
	@Column(name="cd_funcionario")
	@GeneratedValue(generator="seqFuncionario", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_funcionario", nullable=false)
	private String nome;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar nascimento;
	
	@Column(name="vl_salario", table="emp_dado_funcionario")
	private double salario;
	
	@Column(name="nr_agencia", table="emp_dado_funcionario")
	private int agencia;
	
	@Column(name="nr_conta", table="emp_dado_funcionario")
	private int conta;
	
	public Funcionario() {}

	public Funcionario(int codigo, String nome, Calendar nascimento) {
		this.codigo = codigo;
		this.nome = nome;
		this.nascimento = nascimento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}
}
