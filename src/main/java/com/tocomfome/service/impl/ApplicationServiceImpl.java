package com.tocomfome.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.tocomfome.model.Usuario;
import com.tocomfome.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationContext applicationContext;

	private Usuario usuario;

	private Object getEntrada(Scanner teclado, Class<?> type) {
		if (type.equals(Long.class))
			return teclado.nextLong();
		else if (type.equals(BigDecimal.class))
			return teclado.nextBigDecimal();
		else if (type.equals(Integer.class))
			return teclado.nextInt();

		return teclado.nextLine();

	}

	@Override
	public Object lerOpcao(Scanner teclado, List<Object> opcoesValidas) {
		Object retorno = getEntrada(teclado, opcoesValidas.get(0).getClass());
		while (opcoesValidas.indexOf(retorno) == -1) {
			System.out.println("Opção inválida!, digite novamente:");
			retorno = getEntrada(teclado, opcoesValidas.get(0).getClass());
		}

		return retorno;
	}

	@Override
	public Boolean login(Scanner teclado, Usuario usuario) {
		String senha;
		int i = 0;

		System.out.println("Informe sua senha:");
		do {
			if (i == 4) {
				System.out.println("Erro de login");
				return false;
			}

			senha = teclado.nextLine();
			if (usuario.getSenha().equals(senha)) {
				return true;
			}
			i++;

			System.out.println("Senha inválida! Informe novamente:");
		} while (!usuario.getSenha().equals(senha));

		return true;
	}

	@Override
	public void matarAplicacao() {
		System.out.println("Aplicação finalizada");
		SpringApplication.exit(applicationContext, () -> 0);
		System.exit(0);
	}

	@Override
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Usuario getUsuario() {
		return usuario;
	}
}
