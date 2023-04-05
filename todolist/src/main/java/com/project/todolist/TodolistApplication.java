package com.project.todolist;

import com.project.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}


	@Autowired
	private TaskRepository taskRepository;


	@Override
	public void run(String... args) throws Exception{}
}
