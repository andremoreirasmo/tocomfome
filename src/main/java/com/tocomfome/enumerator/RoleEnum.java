package com.tocomfome.enumerator;

import java.util.HashMap;
import java.util.Map;

public enum RoleEnum {

	ADMIN(1L),

	USER(2L);

	private Long intValue;
	private static Map<Long, RoleEnum> map = new HashMap<>();

	private RoleEnum(Long intValue) {
		this.intValue = intValue;
	}

	public Long getIntValue() {
		return intValue;
	}

	static {
		for (RoleEnum role : RoleEnum.values()) {
			map.put(role.intValue, role);
		}
	}

	public static RoleEnum getValueOf(Long codigo) {
		return map.get(codigo);
	}

}
