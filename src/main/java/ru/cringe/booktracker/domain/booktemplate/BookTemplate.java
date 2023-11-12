package ru.cringe.booktracker.domain.booktemplate;

import jakarta.persistence.*;
import lombok.Data;
import ru.cringe.booktracker.domain.author.Author;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "book_templates")
@Data
public class BookTemplate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany
    @JoinTable(name = "book_templates_authors",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_template_id")})
    private List<Author> authors;

    @Column(name = "genre")
    @ElementCollection
    @CollectionTable(name = "book_templates_genres")
    @Enumerated(value = EnumType.STRING)
    private List<Genre> genres;
}
