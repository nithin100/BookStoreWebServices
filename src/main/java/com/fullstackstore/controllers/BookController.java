package com.fullstackstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackstore.entities.Book;
import com.fullstackstore.resources.BookListResource;
import com.fullstackstore.resources.BookListResourceAssembler;
import com.fullstackstore.resources.BookResource;
import com.fullstackstore.resources.BookResourceAssembler;
import com.fullstackstore.services.BookService;
import com.fullstackstore.util.BookList;

@RestController
public class BookController {

	@Autowired
	private BookResourceAssembler bookResourceAssembler;
	@Autowired
	private BookListResourceAssembler bookListResourceAssembler;

	// BookListResourceAssembler bookListResourceAssembler = new
	// BookListResourceAssembler();

	@Autowired
	private BookService bookService;

	@CrossOrigin(origins = "http://localhost:8000")
	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public HttpEntity<BookResource> getAnExistingBookWithId(@PathVariable("id") int id) {
		BookResource bookResource = bookResourceAssembler.toResource(bookService.getBookWithId(id));
		return new ResponseEntity<BookResource>(bookResource, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public HttpEntity<BookListResource> getListOfBooks() {
		System.out.println("In Request!");
		List<Book> bookList = bookService.getListOfBooks();
		BookList listOfBooks = new BookList();
		listOfBooks.setListOfBooks(bookList);
		return new ResponseEntity<BookListResource>(bookListResourceAssembler.toResource(listOfBooks), HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public void addANewBookToTheShelf(@RequestBody BookResource bookToBeAdded) {
		System.out.println("Print Hello");
		Book newBookToBeAddedToTheShelf = new Book();
		newBookToBeAddedToTheShelf.setBookName(bookToBeAdded.getBookName());
		newBookToBeAddedToTheShelf.setBookAuthor(bookToBeAdded.getBookAuthor());
		newBookToBeAddedToTheShelf.setBookPrice(bookToBeAdded.getBookPrice());
		newBookToBeAddedToTheShelf.setBookPublisher(bookToBeAdded.getBookPublisher());
		bookService.addBookToTheStore(newBookToBeAddedToTheShelf);
		System.out.println("Book Added To The Shelf");
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
	public Book updateAnExistingBook(@PathVariable("id") int id, @RequestBody BookResource updatedExistingBook) {
		System.out.println("Called Me!");
		Book updatedBook = new Book();
		updatedBook.setId(id);
		updatedBook.setBookName(updatedExistingBook.getBookName());
		updatedBook.setBookAuthor(updatedExistingBook.getBookAuthor());
		updatedBook.setBookPrice(updatedExistingBook.getBookPrice());
		updatedBook.setBookPublisher(updatedExistingBook.getBookPublisher());
		System.out.println(updatedBook);
		Book theUpdated = bookService.updateExistingBook(id, updatedBook);
		return theUpdated;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	public void deleteAnExistingBook(@PathVariable("id") int id) {
		bookService.deleteAnExistingBook(id);
		System.out.println("Book Deleted");
	}

}
