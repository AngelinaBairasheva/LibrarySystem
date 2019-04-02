package com.springapp.mvc.service;

import com.springapp.mvc.domain.Author;

import java.util.List;

public interface AuthorService {

    void addAuthor(Author author);

    Author getAuthor(Long authorId);

    Author updateAuthor(Long authorId, Author author);

    void deleteAuthor(Long authorId);

    List<Author> getAllAuthors();

}
