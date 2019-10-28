package com.todo.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoApp {

	public static void main(String[] args) {
//		H2ServerConfiguration h2ServerConfiguration = new H2ServerConfiguration();
		SpringApplication.run(ToDoApp.class, args);
	}

}
