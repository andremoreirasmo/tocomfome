package com.tocomfome.service.impl;

import static com.tocomfome.enumerator.StatusPedidoEnum.NAO_CONFIRMADO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tocomfome.dto.PedidoDTO;
import com.tocomfome.model.DetalhePedido;
import com.tocomfome.model.Pedido;
import com.tocomfome.repository.DetalhePedidoRepository;
import com.tocomfome.repository.PedidoRepository;
import com.tocomfome.repository.ProdutoRepository;
import com.tocomfome.service.ApplicationService;
import com.tocomfome.service.PedidoService;
import com.tocomfome.service.ProdutoService;
import com.tocomfome.util.ListUtil;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	@Lazy
	private ProdutoService produtoService;

	@Autowired
	@Lazy
	private ProdutoRepository produtoRepository;

	@Autowired
	@Lazy
	private ApplicationService applicationService;

	@Autowired
	@Lazy
	private PedidoRepository pedidoRepository;

	@Autowired
	@Lazy
	private DetalhePedidoRepository detalhePedidoRepository;

	private List<DetalhePedido> getDetalhesPedido(Scanner teclado) {
		Map<Long, DetalhePedido> mapDetalhaPedido = new HashMap<>();
		int iOpcao;
		do {
			produtoRepository.findByAtivoTrue().forEach(oProduto -> System.out.println(oProduto.toString()));

			System.out.println("Informe o codigo do produto:");
			Long iCodigoProduto = teclado.nextLong();

			if (!mapDetalhaPedido.containsKey(iCodigoProduto)) {
				produtoService.getProduto(iCodigoProduto).ifPresent(oProduto -> {
					DetalhePedido oDetalhe = new DetalhePedido();
					oDetalhe.setIdProduto(iCodigoProduto);
					oDetalhe.setValor(oProduto.getValor());

					System.out.println("Informe a quantidade do produto:");
					oDetalhe.setQuantidade(teclado.nextLong());

					mapDetalhaPedido.put(iCodigoProduto, oDetalhe);
				});
			} else {
				System.out.println("O que deseja fazer? [Excluir produto: 1 / Editar quantidade: 2]");

				switch ((Integer) applicationService.lerOpcao(teclado, ListUtil.toListArray(1, 2))) {
				case 1: {
					mapDetalhaPedido.remove(iCodigoProduto);
					break;
				}

				case 2: {
					System.out.println("Informe a quantidade do produto:");
					mapDetalhaPedido.get(iCodigoProduto).setQuantidade(teclado.nextLong());
					break;
				}

				default:
					break;
				}
			}

			System.out.println("Deseja continuar? [Sim: 1 / Não: 2]");
			iOpcao = (Integer) applicationService.lerOpcao(teclado, ListUtil.toListArray(1, 2));
		} while (iOpcao != 2);

		return mapDetalhaPedido.values().stream().collect(Collectors.toList());
	}

	@Override
	public PedidoDTO efetuarPedido(Scanner teclado) {
		PedidoDTO oRetorno = new PedidoDTO();

		oRetorno.setListaDetalhe(getDetalhesPedido(teclado));

		oRetorno.setPedido(new Pedido());
		oRetorno.getPedido().setStatus(NAO_CONFIRMADO.getIntValue());

		System.out.println("Informe o endereço da entrega:");
		oRetorno.getPedido().setEndereco(teclado.nextLine());
		return oRetorno;
	}

	@Override
	@Transactional
	public void salvarPedido(Scanner teclado, PedidoDTO pedido) {
		Pedido oPedido = pedidoRepository.save(pedido.getPedido());

		for (DetalhePedido oDetalhe : pedido.getListaDetalhe()) {
			oDetalhe.setIdPedido(oPedido.getId());
		}

		detalhePedidoRepository.saveAll(pedido.getListaDetalhe());
	}

	@Override
	public List<DetalhePedido> getDetalhePedido(Long idPedido) {
		return detalhePedidoRepository.findByidPedido(idPedido);
	}

	@Override
	public Optional<Pedido> getPedido(Scanner teclado, List<Pedido> listaPedido) {
		System.out.println("Informe o codigo do pedido:");

		Long iCodigoPedido = teclado.nextLong();
		Optional<Pedido> optionalPedido = listaPedido.stream().filter(oPedido -> oPedido.getId().equals(iCodigoPedido))
				.findAny();

		if (optionalPedido.isPresent())
			System.out.println("Codigo do pedido inválido!");

		return optionalPedido;
	}
}
