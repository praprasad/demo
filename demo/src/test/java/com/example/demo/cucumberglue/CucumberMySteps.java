package com.example.demo.cucumberglue;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = "server.port=7070")
@CucumberContextConfiguration
public class CucumberMySteps {

	@LocalServerPort
	String port;
	ResponseEntity<String> lastResponse;

	@When("the user calls endpoint {string}")
	public void whenClientCalls(String url) {
		try {
			lastResponse = new RestTemplate().exchange("http://localhost:" + port + url, HttpMethod.GET, null,
					String.class);
		} catch (HttpClientErrorException httpClientErrorException) {
			httpClientErrorException.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@Then("response status code is {int}")
	public void thenStatusCodee(int expected) {
		Assertions.assertNotNull(lastResponse);
		Assertions.assertNotNull(lastResponse.getStatusCode());
		assertThat("status code is" + expected, lastResponse.getStatusCodeValue() == expected);
	}

	@Then("returned string should be {string}")
	public void thenStringIs(String expected) {
		if (lastResponse.getBody().contains(expected)) {
			Assertions.assertEquals("true", "true");
		} else {
			Assertions.assertEquals("true", "false");
		}
	}

	@Then("returned string should not contain {string}")
	public void thenStringShouldNotbe(String expected) {
		if (lastResponse.getBody().contains(expected)) {
			Assertions.assertEquals("true", "false");
		} else {
			Assertions.assertEquals("true", "true");
		}
	}

}
