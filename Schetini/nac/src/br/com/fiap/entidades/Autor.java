package br.com.fiap.entidades;

import java.util.Calendar;
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
@Table(name="T_NAC_AUTOR")
@SequenceGenerator(name="seqAutor", sequenceName="SQ_T_NAC_AUTOR", allocationSize=1)
public class Autor {

	@Id
	@Column(name="CD_AUTOR")
	@GeneratedValue(generator="seqAutor", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="NM_AUTOR", length=150, nullable=false)
	private String autor;
	
	@Column(name="DT_NASCIMENTO")
	private Calendar nascimento;
	
	@ManyToMany(mappedBy="autores", cascade=CascadeType.PERSIST)
	private List<Livro> livros;
	
	public Autor() {}

	public Autor(String autor, Calendar nascimento) {
		super();
		this.autor = autor;
		this.nascimento = nascimento;
	}

	public int getCodigo() { return codigo; }

	public void setCodigo(int codigo) { this.codigo = codigo; }

	public String getAutor() { return autor; }

	public void setAutor(String autor) { this.autor = autor; }

	public Calendar getNascimento() { return nascimento; }

	public void setNascimento(Calendar nascimento) { this.nascimento = nascimento; }
	
}
