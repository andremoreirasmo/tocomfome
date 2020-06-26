package com.tocomfome.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
@SequenceGenerator(name = "gen_pedido", sequenceName = "gen_pedido", allocationSize = 1)
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_pedido")
	private Long id;

	@Column(name = "status")
	private Long status;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "idcliente")
	private Long idCliente;

	@Column(name = "valortotal")
	private BigDecimal valorTotal;

	@OneToOne()
	@JoinColumn(name = "idcliente", insertable = false, updatable = false)
	private Usuario cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

}
