package com.springapp.mvc.service.impl;

import com.springapp.mvc.domain.Author;
import com.springapp.mvc.domain.BooksReservation;
import com.springapp.mvc.repository.BooksReservationRepository;
import com.springapp.mvc.service.BooksReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksReservationServiceImpl implements BooksReservationService {

    @Autowired
    private BooksReservationRepository booksReservationRepository;

    @Override
    public void addBooksReservation(BooksReservation booksReservation) {
        booksReservationRepository.save(booksReservation);
    }

    @Override
    public BooksReservation getBooksReservation(Long booksReservationId) {
        return booksReservationRepository.findById(booksReservationId).orElse(null);
    }

    @Override
    public BooksReservation updateBooksReservation(BooksReservation booksReservation) {
        return booksReservationRepository.save(booksReservation);
    }

    @Override
    public void deleteBooksReservation(Long booksReservationId) {
        booksReservationRepository.deleteById(booksReservationId);
    }

    @Override
    public List<BooksReservation> getAllBooksReservations() {
        List<BooksReservation> booksReservations = new ArrayList<>();
        booksReservationRepository.findAll().forEach(booksReservations::add);
        return booksReservations;
    }
}

