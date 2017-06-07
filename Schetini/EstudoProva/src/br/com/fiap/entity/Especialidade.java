package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_ESPECIALIDADE")
@SequenceGenerator(name="seqEspecialidade", sequenceName="SQ_T_ESPECIALIDADE", allocationSize=1)
public class Especialidade {

	@Id
	@Column(name="CD_ESPECIALIDADE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqEspecialidade")
	private int codigo;
	
	@Column(name="NM_ESPECIALIDADE", nullable=false)
	private String nome;
	
	@Column(name="DS_ESPECIALIDADE")
	private String descricao;
	
	@ManyToMany(mappedBy="especialidades", cascade=CascadeType.PERSIST)
	private List<Medico> medicos;
	
	public Especialidade() {}

	public Especialidade(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public int getCodigo() { return codigo; }

	public void setCodigo(int codigo) { this.codigo = codigo; }

	public String getNome() { return nome; }

	public void setNome(String nome) { this.nome = nome; }

	public String getDescricao() { return descricao; }

	public void setDescricao(String descricao) { this.descricao = descricao; }

	public List<Medico> getMedicos() { return medicos; }

	public void setMedicos(List<Medico> medicos) { this.medicos = medicos; }
}
