package br.com.futebol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_tecnico")
@SequenceGenerator(name="seqTecnico", sequenceName="sq_tecnico", allocationSize=1)
public class Tecnico {

	@Id
	@GeneratedValue(generator="seqTecnico", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_tecnico")
	private String nome;
	
	@OneToOne(mappedBy="tecnico")
	private Time time;
	
	public Tecnico() {
	}

	public Tecnico(String nome) {
		this.nome = nome;
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

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
}
