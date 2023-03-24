package com.example.demo.controller;

import org.springframework.stereotype.Component;

/**
 * Book class is used define getter and setter for all the required fields from the book details file
 * @author PrPrasad
 *
 */
@Component
public class Book {
	
	private String title;
	private String author;
	private String price;
	
	
	
	
public Book() {
		super();
	}


public Book(String title, String author, String price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	
	public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public String getAuthor() {
	return author;
}


public void setAuthor(String author) {
	this.author = author;
}


public String getPrice() {
	return price;
}


public void setPrice(String price) {
	this.price = price;
}


	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	
}
