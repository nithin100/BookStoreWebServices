package com.fullstackstore.services;

import java.util.List;

import com.fullstackstore.entities.Book;

public interface BookService {

	public Book getBookWithId(int id);

	public List<Book> getListOfBooks();

	public Book addBookToTheStore(Book bookToBeAdded);

	public Book updateExistingBook(int id, Book updatedBook);
	
	public Book deleteAnExistingBook(int bookId);

}
