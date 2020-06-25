package com.tocomfome.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.tocomfome.dto.PedidoDTO;
import com.tocomfome.enumerator.RoleEnum;
import com.tocomfome.enumerator.UserActionsEnum;
import com.tocomfome.model.Pedido;
import com.tocomfome.model.Usuario;
import com.tocomfome.repository.PedidoRepository;
import com.tocomfome.repository.ProdutoRepository;
import com.tocomfome.repository.UsuarioRepository;
import com.tocomfome.service.ApplicationService;
import com.tocomfome.service.PedidoService;
import com.tocomfome.service.ProdutoService;
import com.tocomfome.service.UserService;
import com.tocomfome.util.ListUtil;

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

	@Autowired
	@Lazy
	private UsuarioRepository usuarioRepository;

	@Autowired
	@Lazy
	private ApplicationService applicationService;

	@Autowired
	@Lazy
	private PedidoService pedidoService;

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
				fazerPedido(teclado);
				break;
			}
			case CANCELAR_PEDIDO: {
				cancelarPedido(teclado);
				break;
			}
			case PEDIDOS: {
				Pedidos(teclado);
				break;
			}

			default:
				break;

			}

		} while (action != UserActionsEnum.SAIR);
	}

	@Override
	public Usuario cadastroUser(Scanner teclado) {
		System.out.println("Informe o email:");
		String sEmail = teclado.nextLine();

		Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(sEmail);

		optionalUsuario.ifPresent(user -> {
			System.out.println("Email já cadastrado!");
			applicationService.matarAplicacao();
		});

		Usuario oUsuario = new Usuario();
		oUsuario.setEmail(sEmail);

		System.out.println("Informe uma senha:");
		oUsuario.setSenha(teclado.nextLine());

		oUsuario.setRole(RoleEnum.USER.getIntValue());
		usuarioRepository.save(oUsuario);

		return oUsuario;
	}

	private void fazerPedido(Scanner teclado) {
		PedidoDTO oPedido = pedidoService.efetuarPedido(teclado);

		System.out.println("Deseja efetivar pedido? [Sim: 1 / Não: 2]");
		if (applicationService.lerOpcao(teclado, ListUtil.toListArray(1, 2)).equals(1))
			pedidoService.salvarPedido(teclado, oPedido);
	}

	private void cancelarPedido(Scanner teclado) {

	}

	private void Pedidos(Scanner teclado) {
		List<Pedido> listaPedidos = pedidoRepository.findAll();
		listaPedidos.forEach(oPedido -> System.out.println(oPedido.toString()));

		System.out.println("O que deseja fazer? [Detalhar pedido: 1/ Voltar: 2]");
		if (applicationService.lerOpcao(teclado, ListUtil.toListArray(1, 2)).equals(1)) {
			System.out.println("Informe o codigo do pedido:");
			Long iCodigoPedido = teclado.nextLong();
			Optional<Pedido> optionalPedido = listaPedidos.stream()
					.filter(oPedido -> oPedido.getId().equals(iCodigoPedido)).findAny();

			if (optionalPedido.isPresent()) {
				pedidoService.getDetalhePedido(iCodigoPedido)
						.forEach(oDetalhe -> System.out.println(oDetalhe.toString()));
			} else {
				System.out.println("Codigo do pedido inválido!");
			}
		}
	}

}
