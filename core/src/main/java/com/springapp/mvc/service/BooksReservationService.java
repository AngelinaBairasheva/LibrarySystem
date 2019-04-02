package com.springapp.mvc.service;

import com.springapp.mvc.domain.BooksReservation;

import java.util.List;

public interface BooksReservationService {

    void addBooksReservation(BooksReservation booksReservationReservation);

    BooksReservation getBooksReservation(Long bookReservationId);

    BooksReservation updateBooksReservation(BooksReservation booksReservation);

    void deleteBooksReservation(Long booksReservationId);

    List<BooksReservation> getAllBooksReservations();

}