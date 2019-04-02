package com.springapp.mvc.service.impl;

import com.springapp.mvc.domain.Author;
import com.springapp.mvc.domain.Book;
import com.springapp.mvc.repository.BookRepository;
import com.springapp.mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book getBook(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public Book updateBook(Long bookId, Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }
}