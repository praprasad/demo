package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.RunnerClass;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private RunnerClass controller;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
