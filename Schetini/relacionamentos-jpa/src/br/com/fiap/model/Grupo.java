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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="am_grupo", schema="system")
@SequenceGenerator(name="seqGrupo", sequenceName="sq_grupo", allocationSize=1)
public class Grupo {

	@Id
	@Column(name="cd_grupo")
	@GeneratedValue(generator="seqGrupo", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_grupo", nullable=false, length=100)
	private String nome;
	
	// relacionamento bi-direcional "grupo" eh o nome do atributo de quem esta sendo mapeado
	// mapped by vai sempre em quem nao recebe a chave
	@OneToOne(mappedBy="grupo", fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	private Projeto projeto;
	
	@OneToMany(mappedBy="grupo", cascade=CascadeType.PERSIST)
	private List<Aluno> alunos;

	public Grupo() {
		alunos = new ArrayList<Aluno>();
	}
	
	public Grupo(String nome, Projeto projeto) {
		this.nome = nome;
		this.projeto = projeto;
		alunos = new ArrayList<Aluno>();
	}

	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
		aluno.setGrupo(this);
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	public Projeto getProjeto() {
		return projeto;
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
}
