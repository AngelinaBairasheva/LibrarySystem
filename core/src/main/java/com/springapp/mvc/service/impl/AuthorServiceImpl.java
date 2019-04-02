package com.springapp.mvc.service.impl;

import com.springapp.mvc.domain.Author;
import com.springapp.mvc.repository.AuthorRepository;
import com.springapp.mvc.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Author getAuthor(Long authorId) {
        return authorRepository.findById(authorId).orElse(null);
    }

    @Override
    public Author updateAuthor(Long authorId, Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }

    @Override
    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().forEach(authors::add);
        return authors;
    }
}
