package com.tocomfome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tocomfome.model.DetalhePedido;

public interface DetalhePedidoRepository extends JpaRepository<DetalhePedido, Long> {
	public abstract List<DetalhePedido> findByidPedido(Long idPedido);
}
