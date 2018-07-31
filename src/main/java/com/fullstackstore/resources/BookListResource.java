package com.fullstackstore.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class BookListResource extends ResourceSupport {

	private List<BookResource> bookResourceList = new ArrayList<BookResource>();

	public List<BookResource> getBookResourceList() {
		return bookResourceList;
	}

	public void setBookResourceList(List<BookResource> bookResourceList) {
		this.bookResourceList = bookResourceList;
	}

}
