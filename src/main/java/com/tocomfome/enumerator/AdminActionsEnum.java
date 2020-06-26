package com.tocomfome.enumerator;

import java.util.HashMap;
import java.util.Map;

public enum AdminActionsEnum {

	NOVO_PRODUTO(1L, "Novo produto"),

	LISTAR_PRODUTO(2L, "Listar Produtos"),

	EDITAR_PRODUTO(3L, "Editar produto"),

	EXCLUIR_PRODUTO(4L, "Excluir produto"),

	LISTAR_PEDIDOS(5L, "Listar pedidos"),

	EDITAR_PEDIDO(6L, "Editar pedido"),

	SAIR(7L, "Sair");

	private Long intValue;
	private String descricao;

	private static Map<Long, AdminActionsEnum> map = new HashMap<>();

	private AdminActionsEnum(Long intValue, String descricao) {
		this.intValue = intValue;
		this.descricao = descricao;
	}

	public Long getIntValue() {
		return intValue;
	}

	public String getDescricao() {
		return descricao;
	}

	static {
		for (AdminActionsEnum action : AdminActionsEnum.values()) {
			map.put(action.intValue, action);
		}
	}

	public static AdminActionsEnum getValueOf(Long codigo) {
		return map.get(codigo);
	}

}
