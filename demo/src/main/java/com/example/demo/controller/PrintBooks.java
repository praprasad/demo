package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class PrintBooks {

	@Autowired
	private CsvReader csv;												// Dependency Injection, No need to create obj from class to access.

	public List<List<String>> printBooksDetails() throws IOException{
		
		List<List<String>> ls1 =csv.parsingCSV();
		ls1.stream().forEach(s->System.out.println(s));					// Use of stream to print the list in the console
		return ls1;
	}
}
