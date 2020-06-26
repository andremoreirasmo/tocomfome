package com.tocomfome.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.tocomfome.model.DetalhePedido;
import com.tocomfome.model.Pedido;
import com.tocomfome.util.BigDecimalUtil;

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

	public BigDecimal valorTotalPedido() {
		return BigDecimalUtil.soma(listaDetalhe.stream().map(DetalhePedido::getTotalDetalhe)
				.collect(Collectors.toList()).toArray(new BigDecimal[0]));
	}

}
