package com.tocomfome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tocomfome.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
