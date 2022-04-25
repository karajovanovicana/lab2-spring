package ukim.finki.emt.lab2.service.impl;

import org.springframework.stereotype.Service;
import ukim.finki.emt.lab2.enumeration.Category;
import ukim.finki.emt.lab2.exception.AuthorNotFoundException;
import ukim.finki.emt.lab2.exception.BookNotFoundException;
import ukim.finki.emt.lab2.model.Author;
import ukim.finki.emt.lab2.model.Book;
import ukim.finki.emt.lab2.model.dto.BookDto;
import ukim.finki.emt.lab2.repository.AuthorRepository;
import ukim.finki.emt.lab2.repository.BookRepository;
import ukim.finki.emt.lab2.service.BookService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Book> save(String name, Category category, Long authorId,
                               Integer availableCopies) {

        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        this.bookRepository.deleteByName(name);
        Book book = new Book(name, category, author, availableCopies);
        this.bookRepository.save(book);

        //this.applicationEventPublisher.publishEvent(new ProductCreatedEvent(product));
        return Optional.of(book);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        this.bookRepository.deleteByName(bookDto.getName());



        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());

        this.bookRepository.save(book);
        //this.refreshMaterializedView();

        return Optional.of(book);
    }


    @Override
    @Transactional
    public Optional<Book> edit(Long id, String name, Category category, Long authorId,
                     Integer availableCopies) {
        Book book = this.bookRepository.
                findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setName(name);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);

        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));
        book.setAuthor(author);

        this.bookRepository.save(book);

        //this.applicationEventPublisher.publishEvent(new ProductCreatedEvent(product));
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setCategory(bookDto.getCategory());
        book.setName(bookDto.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        book.setAuthor(author);

        this.bookRepository.save(book);
        //this.refreshMaterializedView();
//        this.applicationEventPublisher.publishEvent(new ProductCreatedEvent(product));
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Book> markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        if (book.getAvailableCopies() > 0)
            book.setAvailableCopies(book.getAvailableCopies() - 1);
        else
            book.setAvailableCopies(0);
        this.bookRepository.save(book);

        return Optional.of(book);

    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }


}
