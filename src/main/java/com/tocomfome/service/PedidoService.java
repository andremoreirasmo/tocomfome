package com.tocomfome.service;

import java.util.List;
import java.util.Scanner;

import com.tocomfome.dto.PedidoDTO;
import com.tocomfome.model.DetalhePedido;

public interface PedidoService {
	public abstract PedidoDTO efetuarPedido(Scanner teclado);

	public abstract void salvarPedido(Scanner teclado, PedidoDTO pedido);

	public abstract List<DetalhePedido> getDetalhePedido(Long idPedido);
}
