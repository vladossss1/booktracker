package ru.cringe.booktracker.domain.book;

import jakarta.persistence.*;
import lombok.Data;
import ru.cringe.booktracker.domain.booktemplate.BookTemplate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Data
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_template_id", referencedColumnName = "id")
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
