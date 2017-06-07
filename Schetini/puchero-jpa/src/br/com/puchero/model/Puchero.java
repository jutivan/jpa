package br.com.puchero.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pt_puchero", schema="system")
@SequenceGenerator(name="seqPuchero", sequenceName="sq_puchero", allocationSize=1)
public class Puchero {
	

	@Id
	@Column(name="cd_puchero")
	@GeneratedValue(generator="seqPuchero", strategy=GenerationType.SEQUENCE)
	private int id;
	
	
	@Column(name="ds_nome", nullable=false, length=200)
	private String nome;

	
	@OneToMany(mappedBy="puchero", fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Cafetina> cafetinas;
	
	
	public Puchero() {
	}
	
	public Puchero(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Cafetina> getCafetinas() {
		return cafetinas;
	}
	
	public void setCafetinas(List<Cafetina> cafetinas) {
		this.cafetinas = cafetinas;
	}
	
}
