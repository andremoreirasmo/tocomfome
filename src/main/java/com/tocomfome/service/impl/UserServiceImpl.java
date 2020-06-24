package com.tocomfome.service.impl;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.tocomfome.enumerator.UserActionsEnum;
import com.tocomfome.repository.PedidoRepository;
import com.tocomfome.repository.ProdutoRepository;
import com.tocomfome.service.ProdutoService;
import com.tocomfome.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	@Lazy
	private PedidoRepository pedidoRepository;

	@Autowired
	@Lazy
	private ProdutoService produtoService;

	@Autowired
	@Lazy
	private ProdutoRepository produtoRepository;

	@Override
	public void menuUser(Scanner teclado) {
		System.out.println("Bem vindo usuário");

		UserActionsEnum action;

		do {
			System.out.println("O que deseja fazer?");
			for (UserActionsEnum oAction : UserActionsEnum.values()) {
				System.out.println(oAction.getIntValue() + " - " + oAction.getDescricao());
			}

			action = UserActionsEnum.getValueOf(teclado.nextLong());

			switch (action) {
			case FAZER_PEDIDO: {

				break;
			}
			case CANCELAR_PEDIDO: {

				break;
			}
			case STATUS_DO_PEDIDO: {

				break;
			}

			default:
				break;

			}

		} while (action != UserActionsEnum.SAIR);
	}

	private void fazerPedido() {
		do {
			produtoRepository.findByAtivoTrue().forEach(oProduto -> System.out.println(oProduto.toString()));
			
			
			
			
		}while();
	}

}
