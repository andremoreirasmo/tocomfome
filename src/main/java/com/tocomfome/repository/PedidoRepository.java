package com.tocomfome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tocomfome.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	public abstract List<Pedido> findByIdCliente(long idCliente);
}
