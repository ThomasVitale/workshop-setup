package com.thomasvitale.demo;

import java.time.Instant;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private TaskRepository taskRepository;

	@Test
	void contextLoads() {
		var task = new Task(null, "drinking coffee", Instant.now(), LocalDate.now());
		taskRepository.save(task);
		var tasks = taskRepository.findAll();
		assertThat(tasks).hasSize(1);
	}

}
