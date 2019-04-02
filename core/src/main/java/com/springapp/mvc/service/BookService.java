package com.springapp.mvc.service;

import com.springapp.mvc.domain.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    Book getBook(Long bookId);

    Book updateBook(Long bookId, Book book);

    void deleteBook(Long bookId);

    List<Book> getAllBooks();

}
