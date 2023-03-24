package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import io.micrometer.common.util.StringUtils;

@Component 
public class CsvReader {

	/**
	 * Method will parse the CSV file and read the into List of Lists of String and 
	 * return the same for printer component
	 * @return
	 * @throws IOException
	 */
	
	
	
	public List<Book> parsingCSV() throws IOException{
		
		List<Book> records = new ArrayList<>();
		
		String path = System.getProperty("user.dir") + "/src/main/resources/booksdetails.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	
		    	if(StringUtils.isNotEmpty(line)) {
		        String[] values = line.split(",");
		        Book bksObj = new Book();
		        bksObj.setTitle(values[0]);
		        bksObj.setAuthor(values[1]);
		        bksObj.setPrice(values[2]);
		        records.add(bksObj);
		        //records.add(Arrays.asList(values));
		    	}
		    }
		}
		return records;
	}
}
