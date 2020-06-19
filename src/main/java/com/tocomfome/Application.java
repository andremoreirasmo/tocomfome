package com.tocomfome;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tocomfome.model.Produto;
import com.tocomfome.repository.ProdutoRepository;

@SpringBootApplication
@EnableJpaRepositories
public class Application implements CommandLineRunner {

    @Autowired
    ProdutoRepository produtoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Teste!");

        Scanner teclado = new Scanner(System.in);

        Produto oProduto = new Produto();
        System.out.println("Informe a descricao:");
        oProduto.setDescricao(teclado.nextLine());

        oProduto.setAtivo(true);
        System.out.println("Informe o valor:");
        oProduto.setValor(teclado.nextBigDecimal());

        teclado.close();

        produtoRepository.save(oProduto);
        produtoRepository.findAll().forEach(oprod -> System.out.println(oprod.toString()));
    }

}