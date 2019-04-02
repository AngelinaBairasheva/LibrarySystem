package com.springapp.mvc.domain;


import javax.persistence.*;
import java.util.Calendar;
/**
 * Выдача книг
 */
@Entity
@Table(name = "BookReservation")
public class BooksReservation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;
    /**
     * Дата выдачи книги
     **/
    @Column(nullable = false)
    private Calendar reservation_time;
    /**
     * Дата возврата книги
     **/
    @Column(nullable = false)
    private Calendar return_time;

    public BooksReservation() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Calendar getReservation_time() {
        return reservation_time;
    }

    public void setReservation_time(Calendar reservation_time) {
        this.reservation_time = reservation_time;
    }

    public Calendar getReturn_time() {
        return return_time;
    }

    public void setReturn_time(Calendar return_time) {
        this.return_time = return_time;
    }

    public BooksReservation(User user, Book book, Calendar reservation_time, Calendar return_time) {
        this.user = user;
        this.book = book;
        this.reservation_time = reservation_time;
        this.return_time = return_time;
    }

    @Override
    public String toString() {
        return "BooksReservation{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", reservation_time=" + reservation_time +
                ", return_time=" + return_time +
                '}';
    }
}
