package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTesting {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getBookDetails() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:8080/BookDetails", 
						String.class)).contains("Harry Poter");
	}
	
	@Test
	public void validateResponceCode() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
										.andExpect(content().string(containsString("Prabhakar")));
	}
	
}
