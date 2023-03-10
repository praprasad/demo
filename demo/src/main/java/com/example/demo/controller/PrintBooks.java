package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class PrintBooks {

	@Autowired
	private CsvReader csv;												

	/**
	 * Method will print all the book Details which is injected from CsvReader and return the List of 
	 * details for controller method in Runnerclass.
	 * @return
	 * @throws IOException
	 */
	public List<List<String>> printBooksDetails() throws IOException{
		
		List<List<String>> bookDetails =csv.parsingCSV();
		bookDetails.stream().forEach(s->System.out.println(s));					
		return bookDetails;
	}
}
