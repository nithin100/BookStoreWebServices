package com.fullstackstore.resources;

import org.springframework.hateoas.ResourceSupport;

public class BookResource extends ResourceSupport {

	private String bookName;
	private String bookAuthor;
	private double bookPrice;
	private String bookPublisher;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String toString() {
		return this.bookName + " " + this.bookAuthor + " " + this.bookPublisher;
	}

}
