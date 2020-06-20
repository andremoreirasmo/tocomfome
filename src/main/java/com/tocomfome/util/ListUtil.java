package com.tocomfome.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
	private ListUtil() {

	}

	public static <T> List<T> toListArray(@SuppressWarnings("unchecked") T... array) {
		List<T> lista = new ArrayList<>();

		for (T t : array) {
			lista.add(t);
		}

		return lista;
	}
}
