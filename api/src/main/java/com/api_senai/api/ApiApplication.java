package com.api_senai.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api_senai.api.entities.Endereco;

import java.util.Arrays;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

		Endereco.getEnderecoByCep("25645045");
	}

}
