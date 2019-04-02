package com.springapp.mvc.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String hash_password;
    @Column(length = 50, unique = true, nullable = false)
    private String email;
    /**
     * Флаг, что пользователь подтвержден и активен.
     */
    @Column
    private Boolean enabled = false;
    /**
     * Уникальный ключ для подтверждения пользователя, отправляется по почте
     */
    @Column(unique = true)
    private Long us_key;
    /**
     * Права доступа пользователя (возможные значения 'ROLE_USER', 'ROLE_ADMIN')
     */
    private String role;
    /**
     * Список книг, выданных пользователю
     */
    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<BooksReservation> reservationBookList;

    public User() {
    }

    public User(String hash_password, String login, Boolean enabled, Long us_key, String role, List<BooksReservation> reservationBookList) {
        this.hash_password = hash_password;
        this.email = login;
        this.enabled = enabled;
        this.us_key = us_key;
        this.role = role;
        this.reservationBookList = reservationBookList;
    }

    public User(String hash_password, String login, Boolean enabled, Long us_key, String role) {
        this.hash_password = hash_password;
        this.email = login;
        this.enabled = enabled;
        this.us_key = us_key;
        this.role = role;
    }

    public String getHash_password() {
        return hash_password;
    }

    public void setHash_password(String hash_password) {
        this.hash_password = hash_password;
    }

    public String getLogin() {
        return email;
    }

    public void setLogin(String login) {
        this.email = login;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getUs_key() {
        return us_key;
    }

    public void setUs_key(Long us_key) {
        this.us_key = us_key;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<BooksReservation> getReservationBookList() {
        return reservationBookList;
    }

    public void setReservationBookList(List<BooksReservation> reservationBookList) {
        this.reservationBookList = reservationBookList;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (hash_password != null ? hash_password.hashCode() : 0);
        result = 31 * result + (us_key != null ? us_key.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (enabled != user.enabled) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (us_key != null ? !(us_key==user.us_key) : user.us_key != null) return false;
        if (hash_password != null ? !hash_password.equals(user.hash_password) : user.hash_password != null) return false;
        return role != null ? role.equals(user.role) : user.role == null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + hash_password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}