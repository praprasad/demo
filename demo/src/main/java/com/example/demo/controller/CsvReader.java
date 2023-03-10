package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component 
public class CsvReader {

	/**
	 * Method will parse the CSV file and read the into List of Lists of String and 
	 * return the same for printer component
	 * @return
	 * @throws IOException
	 */
	public List<List<String>> parsingCSV() throws IOException{
		
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\PrPrasad\\Downloads\\demo\\demo\\src\\main\\resources\\booksdetails.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        records.add(Arrays.asList(values));
		    }
		}
		return records;
	}
}
