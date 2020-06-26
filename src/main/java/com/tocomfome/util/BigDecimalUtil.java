package com.tocomfome.util;

import java.math.BigDecimal;

public class BigDecimalUtil {
	private BigDecimalUtil() {

	}

	public static BigDecimal multiplica(BigDecimal valor1, BigDecimal valor2) {
		if (valor1 == null || valor2 == null)
			return new BigDecimal(0);

		return valor1.multiply(valor2, java.math.MathContext.DECIMAL64).setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public static BigDecimal soma(BigDecimal... valores) {
		return ListUtil.toListArray(valores).stream().reduce(new BigDecimal(0), BigDecimal::add);
	}
}
