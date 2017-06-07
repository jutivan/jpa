package br.com.empresa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="emp_dependente")
@IdClass(DependentePK.class)
public class Dependente {

	@Id
	@Column(name="cd_dependente")
	@SequenceGenerator(name="seqDependente", sequenceName="sq_emp_dependente")
	@GeneratedValue(generator="seqDependente", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_funcionario")
	private Funcionario funcionario;
	
	@Column(name="nm_dependente")
	private String nome;
	
	public Dependente() {}

	public Dependente(int codigo, Funcionario funcionario, String nome) {
		this.codigo = codigo;
		this.funcionario = funcionario;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
