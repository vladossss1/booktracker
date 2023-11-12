package ru.cringe.booktracker.domain.user;

import jakarta.persistence.*;
import lombok.Data;
import ru.cringe.booktracker.domain.book.Book;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany
    @JoinTable(name = "users_books", inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

    @Column(name = "role")
    @ElementCollection
    @CollectionTable(name = "users_roles")
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles;
}
