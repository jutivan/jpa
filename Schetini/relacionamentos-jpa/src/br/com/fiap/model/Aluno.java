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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="am_aluno")
@SequenceGenerator(name="seqAluno", sequenceName="sq_aluno", allocationSize=1)
public class Aluno {

	@Id
	@GeneratedValue(generator="seqAluno", strategy=GenerationType.SEQUENCE)
	private int rm;
	
	@Column(name="nm_aluno", nullable=false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="cd_grupo")
	private Grupo grupo;
	
	@ManyToMany(mappedBy="alunos", cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<Disciplina> disciplinas;
	
	public Aluno() {
		disciplinas = new ArrayList<Disciplina>();
	}
	
	public Aluno(String nome) {
		this.nome = nome;
		disciplinas = new ArrayList<Disciplina>();
	}
	
	public void addDisciplina(Disciplina disciplina){
		disciplinas.add(disciplina);
		disciplina.addAluno(this);
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}
