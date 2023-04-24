package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movimento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipoMovimento;
	@Temporal(TemporalType.DATE)
	private Date data;
	@Column(nullable = false, scale = 2)
	private Double valor;
	private String categoria;
	@Column(length = 200, nullable = false)
	private String descricao;

	public Movimento() {

	}

	public Movimento(Date data, Double valor) {
		this.data = data;
		this.valor = valor;
	}

	public Movimento(String tipoMovimento, Date data, String categoria, String descricao, Double valor) {
		this.tipoMovimento = tipoMovimento;
		this.data = data;
		this.categoria = categoria;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
