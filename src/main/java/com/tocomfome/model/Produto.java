package com.tocomfome.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@SequenceGenerator(name = "gen_produto", sequenceName = "gen_produto", allocationSize = 1)
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_produto")
	private Long id;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "valor")
	private BigDecimal valor;

	@Column(name = "igredientes")
	private String igredientes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getIgredientes() {
		return igredientes;
	}

	public void setIgredientes(String igredientes) {
		this.igredientes = igredientes;
	}

}
