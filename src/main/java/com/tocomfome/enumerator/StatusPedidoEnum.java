package com.tocomfome.enumerator;

import java.util.HashMap;
import java.util.Map;

public enum StatusPedidoEnum {
	NAO_CONFIRMADO(1L, "Pedido ainda não confirmado"),

	CONFIRMADO(2L, "Pedido confirmado"),

	RECUSADO(3L, "Pedido recusado"),

	EM_PREPARO(4L, "Pedido em preparo"),

	ENTREGA(5L, "Pedido saiu para entrega"),

	FINALIZADO(6L, "Pedido finalizado");

	private Long intValue;
	private String descricao;

	private static Map<Long, StatusPedidoEnum> map = new HashMap<>();

	private StatusPedidoEnum(Long intValue, String descricao) {
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
		for (StatusPedidoEnum pedido : StatusPedidoEnum.values()) {
			map.put(pedido.intValue, pedido);
		}
	}

	public static StatusPedidoEnum getValueOf(Long codigo) {
		return map.get(codigo);
	}
}
