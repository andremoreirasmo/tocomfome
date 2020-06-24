package com.tocomfome.service;

import java.util.Scanner;

import com.tocomfome.model.Usuario;

public interface UserService {
	public abstract void menuUser(Scanner teclado);

	public abstract Usuario cadastroUser(Scanner teclado);

}
