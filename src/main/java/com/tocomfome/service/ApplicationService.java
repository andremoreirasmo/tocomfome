package com.tocomfome.service;

import java.util.List;
import java.util.Scanner;

import com.tocomfome.model.Usuario;

public interface ApplicationService {

	public abstract Object lerOpcao(Scanner teclado, List<Object> opcoesValidas);

	public abstract void matarAplicacao();

	public abstract Boolean login(Scanner teclado, Usuario usuario);
}
