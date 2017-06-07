package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_apartamento", schema="system")
@SequenceGenerator(name="seqAp",sequenceName="sq_apartamento",allocationSize=1)
public class Apartamento {

	@Id
	@Column(name="cd_apartamento")
	@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="seqAp")
	private int codigo;
	
	public Apartamento() {
		this.quartos = new ArrayList<>();
	}
	
	@Column(name="ds_endereco")
	private String endereco;
	
	@OneToMany
	private List<Quarto> quartos;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void adicionaQuarto(Quarto quarto) {
		this.quartos.add(quarto);
	}
}
