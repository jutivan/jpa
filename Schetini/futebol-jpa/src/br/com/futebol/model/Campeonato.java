package br.com.futebol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_campeonato")
@SequenceGenerator(name="seqCampeonato", sequenceName="sq_campeonato", allocationSize=1)
public class Campeonato {

	@Id
	@GeneratedValue(generator="seqCampeonato", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_campeonato")
	private String nome;
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(name="tb_campeonato_time", joinColumns=@JoinColumn(name="cd_campeonato"), inverseJoinColumns=@JoinColumn(name="cd_time"))
	private List<Time> times;
	
	public Campeonato() {
		times = new ArrayList<Time>();
	}

	public Campeonato(String nome) {
		times = new ArrayList<Time>();
		this.nome = nome;
	}
	
	public void addTime(Time time) {
		times.add(time);
		time.addCampeonato(this);
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

	public List<Time> getTimes() {
		return times;
	}
}
