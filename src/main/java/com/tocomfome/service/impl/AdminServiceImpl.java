package com.tocomfome.service.impl;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.tocomfome.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Override
	public void menuAdmin(Scanner teclado) {
		System.out.println("Bem vindo adminstrador!");
		do {
			System.out.println("O que deseja fazer?");
			System.out.println("1 - Novo produto");
			System.out.println("2 - Editar produto");
			System.out.println("3 - Listar produtos");
			System.out.println("4 - Editar pedido");
			System.out.println("5 - Listar pedidos");
			System.out.println("6 - Sair");

		} while (true);
	}
}
