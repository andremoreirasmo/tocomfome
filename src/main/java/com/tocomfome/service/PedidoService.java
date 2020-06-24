package com.tocomfome.service;

import java.util.Scanner;

import com.tocomfome.dto.PedidoDTO;

public interface PedidoService {
	public abstract PedidoDTO efetuarPedido(Scanner teclado);

	public abstract void salvarPedido(Scanner teclado, PedidoDTO pedido);
}
