package com.tocomfome;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tocomfome.enumerator.RoleEnum;
import com.tocomfome.model.Usuario;
import com.tocomfome.repository.UsuarioRepository;
import com.tocomfome.service.AdminService;
import com.tocomfome.service.ApplicationService;
import com.tocomfome.service.UserService;
import com.tocomfome.util.ListUtil;

@SpringBootApplication
@EnableJpaRepositories
public class Application implements CommandLineRunner {

	@Autowired
	@Lazy
	private ApplicationService applicationService;

	@Autowired
	@Lazy
	private AdminService adminService;

	@Autowired
	@Lazy
	private UserService userService;

	@Autowired
	@Lazy
	private UsuarioRepository usuarioRepository;

	private Usuario usuario;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Seja bem vindo To com fome delivery!");
		try (Scanner teclado = new Scanner(System.in)) {
			System.out.println("Escolha a opção: 1- Login | 2 - Cadastro");
			int iOpcao = (Integer) applicationService.lerOpcao(teclado, ListUtil.toListArray(1, 2));

			switch (iOpcao) {
			case 1: {
				System.out.println("Informe o email");
				teclado.nextLine();
				Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(teclado.nextLine());

				if (optionalUsuario.isPresent()) {
					usuario = optionalUsuario.get();

					if (!applicationService.login(teclado, usuario))
						applicationService.matarAplicacao();
				} else {
					System.out.println("Email não encontrado!");
					applicationService.matarAplicacao();
				}

				break;
			}

			case 2: {
				usuario = userService.cadastroUser(teclado);
				break;
			}

			default:
				break;
			}

			switch (RoleEnum.getValueOf(usuario.getRole())) {
			case ADMIN: {
				adminService.menuAdmin(teclado);
				break;
			}
			case USER: {
				userService.menuUser(teclado);
				break;
			}

			default:
				applicationService.matarAplicacao();
			}
		}
	}
}