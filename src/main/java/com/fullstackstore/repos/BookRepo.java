package com.fullstackstore.repos;

import java.util.List;

import com.fullstackstore.entities.Book;

public interface BookRepo {

	public Book getBookWithId(int id);

	public List<Book> getListOfBooks();

	public Book addBookToTheStore(Book bookToBeAdded);

	public Book updateExistingBook(int id, Book bookResourceExisting);
	
	public Book deleteAnExistingBook(int bookId);

}
