package com.jonathangarcia.webapp.bibliotecajg;
import com.jonathangarcia.webapp.bibliotecajg.system.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;

@SpringBootApplication
public class BibliotecajgApplication {

	public static void main(String[] args) {
		//levanta JAVAFX
		Application.launch(Main.class, args);
		//levanta SpringBoot
		SpringApplication.run(BibliotecajgApplication.class, args);
	}

}
