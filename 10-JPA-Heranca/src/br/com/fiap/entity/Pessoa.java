package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PESSOA")
@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="TIPO")
@SequenceGenerator(name="seqPessoa",sequenceName="SQ_T_PESSOA",allocationSize=1)
public class Pessoa {

	@Id
	@Column(name="CD_PESSOA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqPessoa")
	private int codigo;
	
	@Column(name="NM_PESSOA",nullable=false)
	private String nome;
	
	@Column(name="DS_EMAIL")
	private String email;
	
	public Pessoa(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	
	public Pessoa() {
		super();
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
