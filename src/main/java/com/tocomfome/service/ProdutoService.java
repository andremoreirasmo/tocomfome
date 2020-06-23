package com.tocomfome.service;

import java.util.Optional;
import java.util.Scanner;

import com.tocomfome.model.Produto;

public interface ProdutoService {
	public abstract void setarInformacoesProdutos(Produto produto, Scanner teclado);

	public abstract Optional<Produto> getProduto(Long id);
}
