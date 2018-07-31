package com.fullstackstore.resources;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.fullstackstore.controllers.BookController;
import com.fullstackstore.entities.Book;

@Component
public class BookResourceAssembler extends ResourceAssemblerSupport<Book, BookResource> {

	public BookResourceAssembler() {
		super(BookController.class, BookResource.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BookResource toResource(Book book) {
		BookResource bookResource = new BookResource();
		bookResource.setBookName(book.getBookName());
		bookResource.setBookAuthor(book.getBookAuthor());
		bookResource.setBookPrice(book.getBookPrice());
		bookResource.setBookPublisher(book.getBookPublisher());
		Link link = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(BookController.class).getAnExistingBookWithId(book.getId())).withSelfRel();
		bookResource.add(link);
		return bookResource;
	}

}
