package com.springapp.mvc.domain;

import javax.persistence.*;
/**
 * Физическое расположение книги (комната, полка)
 */
@Entity
@Table(name = "Location")
public class Location {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Номер комнаты
     */
    @Column(nullable = false)
    private Integer room;
    /**
     * Номер полки
     */
    @Column(length = 2, nullable = false)
    private Integer bookshelf;
    @OneToOne
    private Book book;

    public Location() {
    }

    public Location(Integer room, Integer bookshelf, Book book) {
        this.room = room;
        this.bookshelf = bookshelf;
        this.book = book;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(Integer bookshelf) {
        this.bookshelf = bookshelf;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", room=" + room +
                ", bookshelf=" + bookshelf +
                ", book=" + book +
                '}';
    }
}
