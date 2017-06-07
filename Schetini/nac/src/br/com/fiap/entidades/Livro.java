package br.com.fiap.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_NAC_LIVRO")
@SequenceGenerator(name="seqLivro", sequenceName="SQ_T_NAC_LIVRO", allocationSize=1)
public class Livro {

	@Id
	@Column(name="NR_ISBN", length=50)
	@GeneratedValue(generator="seqLivro", strategy=GenerationType.SEQUENCE)
	private int isbn;
	
	@Column(name="DS_TITULO", nullable=false, length=200)
	private String titulo;
	
	@Lob
	@Column(name="FL_CAPA")
	private byte[] capa;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="CD_EDITORA")
	private Editora editora;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
			name="T_NAC_AUTOR_LIVRO",
			joinColumns=@JoinColumn(name="NR_ISBN"),
			inverseJoinColumns=@JoinColumn(name="CD_AUTOR")
	)
	private List<Autor> autores;
	
	public Livro() {}

	public Livro(String titulo, byte[] capa, Editora editora) {
		super();
		this.titulo = titulo;
		this.capa = capa;
		this.editora = editora;
	}

	public int getIsbn() { return isbn; }

	public void setIsbn(int isbn) { this.isbn = isbn; }

	public String getTitulo() { return titulo; }

	public void setTitulo(String titulo) { this.titulo = titulo; }

	public byte[] getCapa() { return capa; }

	public void setCapa(byte[] capa) { this.capa = capa; }

	public Editora getEditora() { return editora; }

	public void setEditora(Editora editora) { this.editora = editora; }
	
	public List<Autor> getAutores() {
		if(autores == null)
			autores = new ArrayList<Autor>();
		return autores;
	}
	
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
}
