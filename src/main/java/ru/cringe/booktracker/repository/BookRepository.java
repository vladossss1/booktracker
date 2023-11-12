package ru.cringe.booktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.cringe.booktracker.domain.book.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = """
            SELECT * FROM books b
            JOIN users_books ub ON ub.book_id = b.id
            WHERE ub.user_id = :userId
            """, nativeQuery = true)
    List<Book> findAllByUserId(Long userId);
}
