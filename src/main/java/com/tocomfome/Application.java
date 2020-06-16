package com.tocomfome;

import org.springframework.boot.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tocomfome.repository.ProdutoRepository;

import org.springframework.boot.CommandLineRunner;

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
        
        produtoRepository.findAll().forEach(oprod -> System.out.println(oprod.toString()));
    }

}