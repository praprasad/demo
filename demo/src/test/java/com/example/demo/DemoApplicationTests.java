package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.RunnerClass;

//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = "server.port=7070")
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private RunnerClass controller;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * Smoke Test Case: Validate if able to load controller.
	 */
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
	
	
	
	/**
	 * Validate the book tittle in the response body. Positive Test Case.
	 * 
	 * @throws Exception
	 */
	@Test
	public void getBookDetails() throws Exception { assertThat(this.restTemplate.getForObject("http://localhost:7070/BookDetails",
						String.class)).contains("Harry Potter");
	}
	
	/**
	 * Validate the response code 200 with correct writer name in the body - Positive Test case 
	 * @throws Exception
	 */
	
	@Test
	public void validateResponceCode() throws Exception {
		this.mockMvc.perform(get("/BookDetails")).andDo(print()).andExpect(status().isOk())
										.andExpect(content().string(containsString("Prabhakar")));
	}
	
	/**
	 * Validating the invalid response - Negative Test case.
	 * 
	 * @throws Exception
	 */
	@Test
	public void inValidateResponceCode() throws Exception {
		this.mockMvc.perform(get("/Book")).andDo(print()).andExpect(status().is4xxClientError());
	}
}
