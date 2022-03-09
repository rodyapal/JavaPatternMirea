package com.example.task12_spring_lifecycle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task12SpringLifecycleApplication implements CommandLineRunner {
	private final FileHandler fileHandler;

	public Task12SpringLifecycleApplication(FileHandler fileHandler) {
		this.fileHandler = fileHandler;
	}

	public static void main(String[] args) {
		SpringApplication.run(Task12SpringLifecycleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("FileHandler created: " + fileHandler.toString());
	}
}
