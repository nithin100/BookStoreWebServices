package com.fullstackstore.reposimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.fullstackstore.entities.Book;
import com.fullstackstore.repos.BookRepo;

@Transactional
@Repository
public class BookRepoImpl implements BookRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Book getBookWithId(int id) {

		return entityManager.find(Book.class, id);
	}

	@Override
	public List<Book> getListOfBooks() {
		List<Book> listOfBooks = (ArrayList<Book>) entityManager.createQuery("from Book b").getResultList();
		return listOfBooks;
	}

	@Override
	public Book addBookToTheStore(Book bookToBeAdded) {

		entityManager.persist(bookToBeAdded);

		return bookToBeAdded;
	}

	@Override
	public Book updateExistingBook(int id, Book bookResourceExisting) {
		entityManager.createNativeQuery("{call updateExistingBook(?,?,?,?,?)}").setParameter(1, id)
				.setParameter(2, bookResourceExisting.getBookName())
				.setParameter(3, bookResourceExisting.getBookAuthor())
				.setParameter(4, bookResourceExisting.getBookPrice())
				.setParameter(5, bookResourceExisting.getBookPublisher()).executeUpdate();
		return getBookWithId(id);
	}

	@Override
	public Book deleteAnExistingBook(int bookId) {
		Book bookToBeDeleted = getBookWithId(bookId);
		entityManager.remove(bookToBeDeleted);
		return bookToBeDeleted;
	}

}
