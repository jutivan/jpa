package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa {

	@Column(name="NR_CNPJ")
	private String cnpj;
	
	@Column(name="NM_FANTASIA")
	private String nomeFantasia;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, String email, String cnpj, String nomeFantasia) {
		super(nome, email);
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
}
