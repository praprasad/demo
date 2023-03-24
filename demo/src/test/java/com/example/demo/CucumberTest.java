package com.example.demo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features",
	plugin = {"pretty"},
	glue = {"com.example.demo.cucumberglue"}
)


public class CucumberTest {

}
