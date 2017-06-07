package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_PESSOA_FISICA")
//@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa {

	@Column(name="NR_CPF")
	private String cpf;
	
	@Column(name="DS_SEXO")
	private Sexo sexo;
	
	public PessoaFisica() {
		super();
	}

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
