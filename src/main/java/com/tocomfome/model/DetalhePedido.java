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
@Table(name = "detalhepedido")
@SequenceGenerator(name = "gen_pedido", sequenceName = "gen_pedido", allocationSize = 1)
public class DetalhePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_pedido")
	private Long id;

	@Column(name = "idpedido")
	private Long idPedido;

	@Column(name = "idproduto")
	private Long idProduto;

	@Column(name = "quantidade")
	private Long quantidade;

	@Column(name = "valor")
	private BigDecimal valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
