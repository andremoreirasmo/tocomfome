package com.tocomfome.service.impl;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.tocomfome.model.Produto;
import com.tocomfome.repository.ProdutoRepository;
import com.tocomfome.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	@Lazy
	private ProdutoRepository produtoRepository;

	@Override
	public void setarInformacoesProdutos(Produto produto, Scanner teclado) {
		System.out.println("Informe o nome do produto:");
		produto.setDescricao(teclado.nextLine());

		System.out.println("Informe o valor do produto:");
		produto.setValor(teclado.nextBigDecimal());

		teclado.nextLine();
		System.out.println("Informe os ingredientes:");
		produto.setIgredientes(teclado.nextLine());

		produto.setAtivo(true);
	}

	@Override
	public Optional<Produto> getProduto(Long id) {
		Optional<Produto> oOptionalProduto = produtoRepository.findById(id);

		if (!oOptionalProduto.isPresent()) {
			System.out.println("Produto não encontrado!");
		}

		return oOptionalProduto;
	}
}
