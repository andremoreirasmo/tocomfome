package com.tocomfome.dto;

import java.util.List;

import com.tocomfome.model.DetalhePedido;
import com.tocomfome.model.Pedido;

public class PedidoDTO {
	private Pedido pedido;
	private List<DetalhePedido> listaDetalhe;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<DetalhePedido> getListaDetalhe() {
		return listaDetalhe;
	}

	public void setListaDetalhe(List<DetalhePedido> listaDetalhe) {
		this.listaDetalhe = listaDetalhe;
	}

}
