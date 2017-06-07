package br.com.fiap.entity;

import java.util.Calendar;
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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MEDICO")
@SequenceGenerator(name="seqMedico", sequenceName="SQ_T_MEDICO", allocationSize=1)
public class Medico {

	@Id
	@Column(name="CD_MEDICO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqMedico")
	private int codigo;
	
	@Column(name="NM_MEDICO", nullable=false, length=100)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_NASCIMENTO")
	private Calendar dataNascimento;
	
	@Lob
	@Column(name="FL_FOTO")
	private byte[] foto;
	
	@Column(name="DS_SEXO")
	private Sexo sexo;
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(
			name="T_MEDICO_ESPECIALIDADE",
			joinColumns=@JoinColumn(name="CD_MEDICO"),
			inverseJoinColumns=@JoinColumn(name="CD_ESPECIALIDADE")
	)
	private List<Especialidade> especialidades;
	
	public Medico() {}

	public Medico(String nome, Calendar dataNascimento, byte[] foto, Sexo sexo, List<Especialidade> especialidades) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.sexo = sexo;
		this.especialidades = especialidades;
	}

	public String getNome() { return nome; }

	public void setNome(String nome) { this.nome = nome; }

	public Calendar getDataNascimento() { return dataNascimento; }

	public void setDataNascimento(Calendar dataNascimento) { this.dataNascimento = dataNascimento; }

	public byte[] getFoto() { return foto; }

	public void setFoto(byte[] foto) { this.foto = foto; }

	public Sexo getSexo() { return sexo; }

	public void setSexo(Sexo sexo) { this.sexo = sexo; }

	public List<Especialidade> getEspecialidades() { return especialidades; }

	public void setEspecialidades(List<Especialidade> especialidades) { this.especialidades = especialidades; }

}
