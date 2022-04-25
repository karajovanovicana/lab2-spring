package ukim.finki.emt.lab2.service;

import org.springframework.stereotype.Service;
import ukim.finki.emt.lab2.enumeration.Category;
import ukim.finki.emt.lab2.model.Author;
import ukim.finki.emt.lab2.model.Book;
import ukim.finki.emt.lab2.model.dto.BookDto;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Optional;


public interface BookService {
    List<Book> findAll();
    Optional<Book> save(String name, Category category, Long authorId,
                     Integer availableCopies);
    Optional<Book> edit(Long id, String name, Category category, Long authorId,
                               Integer availableCopies);
    void deleteById(Long id);
    Optional<Book> markAsTaken(Long id);

    Optional<Book> findById(Long id);
    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

}
