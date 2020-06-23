package com.tocomfome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tocomfome.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public abstract List<Produto> findByAtivoTrue();
}
