package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="her_pessoa")
@Inheritance(strategy=InheritanceType.JOINED)
@SequenceGenerator(name="seqPessoa", sequenceName="her_sq_pessoa", allocationSize=1)
public abstract class Pessoa {

	@Id
	@Column(name="cd_pessoa")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqPessoa")
	private int codigo;
	
	@Column(name="nm_pessoa")
	private String nome;
	
	@Column(name="ds_email")
	private String email;

	public Pessoa() {}

	public Pessoa(String nome, String email) {
		this.nome = nome;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
