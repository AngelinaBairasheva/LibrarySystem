package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Book;
import com.springapp.mvc.domain.BooksReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksReservationRepository extends JpaRepository<BooksReservation, Long> {
}

