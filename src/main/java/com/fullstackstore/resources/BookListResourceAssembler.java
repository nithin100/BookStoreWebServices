package com.fullstackstore.resources;

import java.util.List;

import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.fullstackstore.util.BookList;

@Component
public class BookListResourceAssembler implements ResourceAssembler<BookList, BookListResource> {

	@Override
	public BookListResource toResource(BookList bookList) {
		BookListResource bookListResource = new BookListResource();
		List<BookResource> listOfBookResources = new BookResourceAssembler().toResources(bookList.getListOfBooks());
		bookListResource.setBookResourceList(listOfBookResources);
		return bookListResource;
	}

}
