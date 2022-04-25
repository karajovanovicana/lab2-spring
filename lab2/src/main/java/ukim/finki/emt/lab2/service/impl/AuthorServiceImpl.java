package ukim.finki.emt.lab2.service.impl;

import org.springframework.stereotype.Service;
import ukim.finki.emt.lab2.model.Author;
import ukim.finki.emt.lab2.model.Country;
import ukim.finki.emt.lab2.repository.AuthorRepository;
import ukim.finki.emt.lab2.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author create(String name, String surname, Country country) {
        Author author = new Author(name, surname, country);
        return this.authorRepository.save(author);
    }
}
