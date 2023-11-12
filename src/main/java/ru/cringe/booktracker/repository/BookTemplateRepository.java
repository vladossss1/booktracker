package ru.cringe.booktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.cringe.booktracker.domain.author.Author;
import ru.cringe.booktracker.domain.booktemplate.BookTemplate;

import java.util.List;

public interface BookTemplateRepository extends JpaRepository<BookTemplate, Long> {

    @Query(value = """
            SELECT * FROM book_templates b
            JOIN book_templates_authors ba ON ba.book_template_id = b.id
            WHERE b.title = :title AND ba.author_id IN :authorIds
            """, nativeQuery = true)
    List<BookTemplate> findAllByTitleAndAuthors(String title, List<Long> authorIds);
    List<BookTemplate> findAllByTitle(String title);

    // List<BookTemplate> findAllByAuthors(List<String> authors);

    // List<BookTemplate> findAllByGenres(List<Genre> genres);
}