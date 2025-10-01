package com.thomasvitale.demo;

import java.time.Instant;
import java.time.LocalDate;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.ListCrudRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

record Task(@Id Long id, String description, Instant creationDate, @Nullable LocalDate dueDate) {}

interface TaskRepository extends ListCrudRepository<Task, Long> {}
