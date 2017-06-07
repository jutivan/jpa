package br.com.puchero.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pt_cafetina", schema="system")
@SequenceGenerator(name="seqCafetina",  sequenceName="sq_cafetina", allocationSize=1)
public class Cafetina {

	
	@Id
	@Column(name="cd_cafetina")
	@GeneratedValue(generator="seqCafetina", strategy=GenerationType.SEQUENCE)
	private int id;
	
	
	@Column(name="nm_cafetina", length=200, nullable=false)
	private String name;
	
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="cd_puchero")
	private Puchero puchero;
	
	
	@OneToMany(mappedBy="cafetina", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	private List<Puta> putas;

	
	public Cafetina() {
	}
	
	public Cafetina(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Puta> getPutas() {
		return putas;
	}
	
	public void setPutas(List<Puta> putas) {
		this.putas = putas;
	}
	
	public Puchero getPuchero() {
		return puchero;
	}
	
	public void setPuchero(Puchero puchero) {
		this.puchero = puchero;
	}
}
