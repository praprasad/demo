package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunnerClass {

	@Autowired
	private PrintBooks booksDetails;
	
	@GetMapping("/BookDetails")													// publishing values on localhost
	public List<Book> publishValue() throws IOException {
		
		List<Book> publishvalue = booksDetails.printBooksDetails();		// Getting values from print Book class
		return publishvalue;
	}
	
}
