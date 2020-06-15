package com.tocomfome.ToComFome;

import org.springframework.boot.SpringApplication;

import java.util.Scanner;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ToComFomeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ToComFomeApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}
	
    @Override
    public void run(String... args) {
    	System.out.println("Teste!");
    }

}