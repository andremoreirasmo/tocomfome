package com.tocomfome.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.tocomfome.enumerator.AdminActionsEnum;
import com.tocomfome.enumerator.StatusPedidoEnum;
import com.tocomfome.model.Pedido;
import com.tocomfome.model.Produto;
import com.tocomfome.repository.PedidoRepository;
import com.tocomfome.repository.ProdutoRepository;
import com.tocomfome.service.AdminService;
import com.tocomfome.service.ApplicationService;
import com.tocomfome.service.ProdutoService;
import com.tocomfome.util.ListUtil;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	@Lazy
	private ApplicationService applicationService;

	@Autowired
	@Lazy
	private ProdutoRepository produtoRepository;

	@Autowired
	@Lazy
	private PedidoRepository pedidoRepository;

	@Autowired
	@Lazy
	private ProdutoService produtoService;

	@Override
	public void menuAdmin(Scanner teclado) {
		System.out.println("Bem vindo adminstrador!");

		AdminActionsEnum action;

		do {

			System.out.println("O que deseja fazer?");
			for (AdminActionsEnum oAction : AdminActionsEnum.values()) {
				System.out.println(oAction.getIntValue() + " - " + oAction.getDescricao());
			}

			action = AdminActionsEnum.getValueOf(teclado.nextLong());

			System.out.println("__________________");
			switch (action) {
			case NOVO_PRODUTO: {
				novoProduto(teclado);
				break;
			}
			case LISTAR_PRODUTO: {
				listarProduto();
				break;
			}
			case EDITAR_PRODUTO: {
				editarProduto(teclado);
				break;
			}
			case EXCLUIR_PRODUTO: {
				excluirProduto(teclado);
				break;
			}
			case LISTAR_PEDIDOS: {
				listarPedidos();
				break;
			}
			case EDITAR_PEDIDO: {
				editarPedido(teclado);
				break;
			}

			default:
				break;

			}
			System.out.println("__________________");

		} while (action != AdminActionsEnum.SAIR);

	}

	private void listarPedidos() {
		List<Pedido> teste = pedidoRepository.findAll();

		for (Pedido oPedido : teste) {
			System.out.println("Codigo: " + oPedido.getId() + ", Status: "
					+ StatusPedidoEnum.getValueOf(oPedido.getStatus()).getDescricao() + ", Valor pedido: "
					+ oPedido.getValorTotal() + ", Endereço:" + oPedido.getEndereco() + ", Cliente: "
					+ oPedido.getCliente().getNome());
		}
	}

	private void editarPedido(Scanner teclado) {
		listarPedidos();

		System.out.println("Informe o código do pedido:");
		Optional<Pedido> oOptionalPedido = pedidoRepository.findById(teclado.nextLong());

		if (oOptionalPedido.isPresent()) {
			Pedido oPedido = oOptionalPedido.get();
			List<StatusPedidoEnum> listaStatus = StatusPedidoEnum
					.getListaStatusValidos(StatusPedidoEnum.getValueOf(oPedido.getStatus()));

			if (listaStatus == null) {
				System.out.println("Não é possivel alterar o pedido!");
			} else {
				System.out.println("Status disponiveis:");
				listaStatus.forEach(status -> System.out.println(status.getIntValue() + " - " + status.getDescricao()));

				System.out.println("Informe um status: ");
				oPedido.setStatus((Long) applicationService.lerOpcao(teclado,
						listaStatus.stream().map(StatusPedidoEnum::getIntValue).collect(Collectors.toList())));

				pedidoRepository.save(oPedido);
			}
		} else {
			System.out.println("Pedido não encontrado");
		}

	}

	private void editarProduto(Scanner teclado) {
		listarProduto();

		System.out.println("Informe o código do produto:");

		produtoService.getProduto(teclado.nextLong()).ifPresent(oProduto -> {
			teclado.nextLine();
			produtoService.setarInformacoesProdutos(oProduto, teclado);

			produtoRepository.save(oProduto);
		});
	}

	private void novoProduto(Scanner teclado) {
		List<Produto> listaProdutos = new ArrayList<>();

		int iOpcao;

		do {
			Produto oProduto = new Produto();

			teclado.nextLine();
			produtoService.setarInformacoesProdutos(oProduto, teclado);
			listaProdutos.add(oProduto);

			System.out.println("Deseja continuar? [Sim: 1 / Não: 2]");
			iOpcao = (Integer) applicationService.lerOpcao(teclado, ListUtil.toListArray(1, 2));
		} while (iOpcao != 2);

		produtoRepository.saveAll(listaProdutos);
	}

	private void listarProduto() {
		produtoRepository.findByAtivoTrue().forEach(oProduto -> System.out.println(oProduto.toString()));
	}

	private void excluirProduto(Scanner teclado) {
		listarProduto();

		System.out.println("Informe o código do produto:");
		produtoService.getProduto(teclado.nextLong()).ifPresent(oProduto -> {
			oProduto.setAtivo(false);

			produtoRepository.save(oProduto);
		});
	}

}