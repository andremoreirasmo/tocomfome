package com.tocomfome.enumerator;

import java.util.HashMap;
import java.util.Map;

public enum UserActionsEnum {

	FAZER_PEDIDO(1L, "Fazer pedido"),

	CANCELAR_PEDIDO(2L, "Cancelar pedido"),

	STATUS_DO_PEDIDO(3L, "Status do pedido"),

	SAIR(4L, "Sair");

	private Long intValue;
	private String descricao;

	private static Map<Long, UserActionsEnum> map = new HashMap<>();

	private UserActionsEnum(Long intValue, String descricao) {
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
		for (UserActionsEnum action : UserActionsEnum.values()) {
			map.put(action.intValue, action);
		}
	}

	public static UserActionsEnum getValueOf(Long codigo) {
		return map.get(codigo);
	}

}
