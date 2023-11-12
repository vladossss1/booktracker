package ru.cringe.booktracker.domain.book;

import jakarta.persistence.*;
import lombok.Data;
import ru.cringe.booktracker.domain.booktemplate.BookTemplate;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinTable(name = "books_book_templates",
            joinColumns = {@JoinColumn(name = "book_template_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private BookTemplate bookTemplate;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    private Short rating;
    private Integer totalPages;
    private Integer currentPage;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private String comment;
}
