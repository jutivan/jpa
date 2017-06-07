package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="TB_CERVEJA")
@SequenceGenerator(name="seqCerveja", sequenceName="SQ_TB_CERVEJA", allocationSize=1)
public class Cerveja {

	@Id
	@Column(name="CD_CERVEJA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqCerveja")
	private int id;
	
	@Column(name="NM_CERVEJA", nullable=false, length=50)
	private String nome;
	
	@Column(name="VL_TEOR_ALCOOLICO")
	private float teorAlcoolico;
	
	@Column(name="VL_PRECO")
	private double preco;
	
	@Column(name="DT_FABRICACAO")
	@Temporal(TemporalType.DATE) //Somente a data no BD
	private Calendar dataFabricacao;
	
	@Column(name="DT_VALIDADE")
	@Temporal(TemporalType.DATE) //Somente a data no BD
	private Calendar dataValidade;
	
	@Column(name="DS_TIPO")
	private TipoCerveja tipo;
	
	@Lob //armazena o arquivo de imagem no BD
	private byte[] logo;
	
	@Transient //Não será mapeado para uma coluna no BD
	private boolean vencido;
	
	public Cerveja(int id, String nome, float teorAlcoolico, double preco, Calendar dataFabricacao,
			Calendar dataValidade, TipoCerveja tipo, byte[] logo, boolean vencido) {
		super();
		this.id = id;
		this.nome = nome;
		this.teorAlcoolico = teorAlcoolico;
		this.preco = preco;
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
		this.tipo = tipo;
		this.logo = logo;
		this.vencido = vencido;
	}

	public Cerveja() {
		super();
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

	public float getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(float teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public TipoCerveja getTipo() {
		return tipo;
	}

	public void setTipo(TipoCerveja tipo) {
		this.tipo = tipo;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public boolean isVencido() {
		return vencido;
	}

	public void setVencido(boolean vencido) {
		this.vencido = vencido;
	}
	
}