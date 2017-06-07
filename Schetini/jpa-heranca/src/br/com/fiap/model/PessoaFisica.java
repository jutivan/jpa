package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="her_pessoa_fisica")
public class PessoaFisica extends Pessoa {

	@Column(name="nr_cpf")
	private String cpf;
	
	@Column(name="ds_sexo")
	private Sexo sexo;
	
	public PessoaFisica() {}

	public PessoaFisica(String nome, String email, String cpf, Sexo sexo) {
		super(nome, email);
		this.cpf = cpf;
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
}
