package com.fullstackstore.util;

import java.util.ArrayList;
import java.util.List;

import com.fullstackstore.entities.Book;

public class BookList {

	private List<Book> listOfBooks = new ArrayList<Book>();

	public List<Book> getListOfBooks() {
		return listOfBooks;
	}

	public void setListOfBooks(List<Book> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}

}
