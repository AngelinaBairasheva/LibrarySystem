package com.springapp.mvc.domain;

import javax.persistence.*; 
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    @Column(name = "ISBN", unique = true,nullable = false)
    private String isbn;
    /**
     * Название книги
     */ 
    @Column(nullable = false)
    private String title;
    /**
     * Издатель
     */ 
    @Column(nullable = false)
    private String publisher;
    @Column(length = 4)
    private Integer year_of_publication;
    /**
     * Количество экземпляров книги
     */ 
    @Column(nullable = false)
    private Integer num_of_copies;
    /**
     * Флаг для информации о наличии свободных экземпляров книги
     */
    @Column(nullable = false)
    private Boolean available = false;
    private String image;

    private BigDecimal price;
    /**
     * Физическое расположение книги (комната, полка)
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Location location;
    @ManyToMany
            (cascade = CascadeType.REFRESH,
                    fetch = FetchType.EAGER)
    @JoinTable(name = "BOOKS_AUTHORS",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
    private List<Author> authors;
    /**
     * Список пользователей, ожидающие книгу для брони
     */
    @ManyToMany
    @JoinTable
            (
                    name = "USER_BOOK_WAITLIST",
                    joinColumns = {@JoinColumn(name = "BOOK_ID")},
                    inverseJoinColumns = {@JoinColumn(name = "USER_ID")}
            )
    List<User> waitlist;
    /**
     * Список пользователей, которым была выдана книга
     */
    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "book")
    private List<BooksReservation> usersList;

    public Book() {
    }

    public Book(String isbn, String title, String publisher, Integer year_of_publication,
                Integer num_of_copies, Boolean available, Location location, List<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.year_of_publication = year_of_publication;
        this.num_of_copies = num_of_copies;
        this.available = available;
        this.location = location;
        this.authors = authors;
    }

    public Book(String isbn, String title, String publisher, Integer year_of_publication,
                Integer num_of_copies, Boolean available, String image, BigDecimal price,
                Location location, List<Author> authors, List<User> waitlist,
                List<BooksReservation> usersList) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.year_of_publication = year_of_publication;
        this.num_of_copies = num_of_copies;
        this.available = available;
        this.image = image;
        this.price = price;
        this.location = location;
        this.authors = authors;
        this.waitlist = waitlist;
        this.usersList = usersList;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(Integer year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    public Integer getNum_of_copies() {
        return num_of_copies;
    }

    public void setNum_of_copies(Integer num_of_copies) {
        this.num_of_copies = num_of_copies;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<User> getWaitlist() {
        return waitlist;
    }
     public void setWaitlist(List<User> waitlist) {
        this.waitlist = waitlist;
    }

    public List<BooksReservation> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<BooksReservation> usersList) {
        this.usersList = usersList;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year_of_publication=" + year_of_publication +
                ", num_of_copies=" + num_of_copies +
                ", available=" + available +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }
}