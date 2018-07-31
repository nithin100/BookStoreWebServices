package com.fullstackstore.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstackstore.entities.Book;
import com.fullstackstore.repos.BookRepo;
import com.fullstackstore.services.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;

	@Override
	public Book getBookWithId(int id) {
		return bookRepo.getBookWithId(id);
	}

	@Override
	public List<Book> getListOfBooks() {
		return bookRepo.getListOfBooks();
	}

	@Override
	public Book addBookToTheStore(Book bookToBeAdded) {
		// TODO Auto-generated method stub
		return bookRepo.addBookToTheStore(bookToBeAdded);
	}

	@Override
	public Book updateExistingBook(int id, Book bookResourceExisting) {
		// TODO Auto-generated method stub
		return bookRepo.updateExistingBook(id, bookResourceExisting);
	}

	@Override
	public Book deleteAnExistingBook(int bookId) {
		// TODO Auto-generated method stub
		return bookRepo.deleteAnExistingBook(bookId);
	}

}
