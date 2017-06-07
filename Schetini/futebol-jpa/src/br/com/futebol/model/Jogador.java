package br.com.futebol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_jogador", schema="system")
@SequenceGenerator(name="seqJogador", sequenceName="sq_jogador", allocationSize=1)
public class Jogador {
	
	@Id
	@Column(name="cd_jogador")
	@GeneratedValue(generator="seqJogador")
	private int codigo;
	
	@Column(name="nm_jogador")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="cd_time")
	private Time time;

	public Jogador() {
	}
	
	public Jogador(String nome) {
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
