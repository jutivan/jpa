package br.com.fiap.model;

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
@Table(name="am_displina", schema="system")
@SequenceGenerator(name="seqDisciplina", sequenceName="sq_disciplina", allocationSize=1)
public class Disciplina {

	@Id
	@Column(name="cd_disciplina")
	@GeneratedValue(generator="seqDisciplina", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_disciplina")
	private String nome;
	
	@Column(name="nr_horas")
	private int cargaHoraria;
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(name="am_aluno_disciplina", 
	joinColumns=@JoinColumn(name="cd_disciplina"), 
	inverseJoinColumns=@JoinColumn(name="cd_aluno"))
	private List<Aluno> alunos;

	public Disciplina(){
		alunos = new ArrayList<Aluno>();
	}
	
	public Disciplina(String nome, int cargaHoraria) {
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		alunos = new ArrayList<Aluno>();
	}
	
	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
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

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
}
