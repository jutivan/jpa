package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="her_pessoa_juridica")
public class PessoaJuridica extends Pessoa {

	@Column(name="nr_cnpj")
	private String cnpj;
	
	@Column(name="nm_fantasia")
	private String nomeFantasia;
	
	public PessoaJuridica() {}

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
