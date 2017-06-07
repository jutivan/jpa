package br.com.fiap.entity;

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
@Table(name="TB_GRUPO_AM")
@SequenceGenerator(name="seqGrupo",
sequenceName="SQ_TB_GRUPO_AM",allocationSize=1)
public class GrupoAm {

	@Id
	@Column(name="CD_GRUPO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqGrupo")
	private int codigo;
	
	@Column(name="NM_GRUPO",nullable=false,length=100)
	private String nome;
	
	//Relacionamento bi-direcional
	//nome do atributo que mapeia a FK na classe ProjetoAm
	@OneToOne(mappedBy="grupo",fetch=FetchType.LAZY)	
	private ProjetoAm projeto;
	
	public GrupoAm(int codigo, String nome, ProjetoAm projeto) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.projeto = projeto;
		alunos = new ArrayList<Aluno>();
	}

	public GrupoAm() {
		super();
		alunos = new ArrayList<Aluno>();
	}

	//Relacionamento bi-direcional
	@OneToMany(mappedBy="grupo", cascade=CascadeType.PERSIST)
	private List<Aluno> alunos;
	
	public void addAluno(Aluno aluno){
		//Adicionar o aluno na lista
		alunos.add(aluno);
		//Setar o grupo do aluno
		aluno.setGrupo(this);
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

	public ProjetoAm getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoAm projeto) {
		this.projeto = projeto;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}
