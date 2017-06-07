package br.com.fiap.entity;

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
@Table(name="T_FUNCIONARIO")
@SecondaryTable(name="T_DADO_FUNCIONARIO")
@SequenceGenerator(name="seqFunc",sequenceName="SQ_T_FUNCIONARIO",allocationSize=1)
public class Funcionario {

	@Id
	@Column(name="CD_FUNCIONARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqFunc")
	private int codigo;
	
	@Column(name="NM_FUNCIONARIO",nullable=false)
	private String nome;
	
	@Column(name="DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Column(name="VL_SALARIO",table="T_DADO_FUNCIONARIO")
	private double salario;
	
	@Column(name="NR_CONTA",table="T_DADO_FUNCIONARIO")
	private int conta;
	
	@Column(name="NR_AGENCIA",table="T_DADO_FUNCIONARIO")
	private int agencia;
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
