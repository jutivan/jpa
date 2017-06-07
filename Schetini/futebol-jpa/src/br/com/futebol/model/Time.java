package br.com.futebol.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_time")
@SequenceGenerator(name="seqTime", sequenceName="sq_time", allocationSize=1)
public class Time {

	@Id
	@GeneratedValue(generator="seqTime", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_time")
	private String nome;
	
	@Column(name="dt_fundacao")
	private Calendar fundacao;
	
	@Column(name="nr_titulo")
	private int titulo;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_tecnico")
	private Tecnico tecnico;
	
	@OneToMany(mappedBy="time", cascade=CascadeType.PERSIST)
	private List<Jogador> jogadores;
	
	@ManyToMany(mappedBy="times", cascade=CascadeType.PERSIST)
	private List<Campeonato> campeonatos;
	
	public Time() {
		jogadores = new ArrayList<Jogador>();
		campeonatos = new ArrayList<Campeonato>();
	}

	public Time(String nome, Calendar fundacao, int titulo) {
		jogadores = new ArrayList<Jogador>();
		campeonatos = new ArrayList<Campeonato>();
		this.nome = nome;
		this.fundacao = fundacao;
		this.titulo = titulo;
	}
	
	public void addJogador(Jogador jogador) {
		jogadores.add(jogador);
		jogador.setTime(this);
	}
	
	public void addTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
		tecnico.setTime(this);
	}

	public void addCampeonato(Campeonato campeonato) {
		campeonatos.add(campeonato);
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

	public Calendar getFundacao() {
		return fundacao;
	}

	public void setFundacao(Calendar fundacao) {
		this.fundacao = fundacao;
	}

	public int getTitulo() {
		return titulo;
	}

	public void setTitulo(int titulo) {
		this.titulo = titulo;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}
	
	public List<Campeonato> getCampeonatos() {
		return campeonatos;
	}
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}

}
