package ukim.finki.emt.lab2.service;

import org.springframework.stereotype.Service;
import ukim.finki.emt.lab2.model.Author;
import ukim.finki.emt.lab2.model.Country;

import java.util.List;


public interface AuthorService {
    public List<Author> findAll();
    public Author create(String name, String surname, Country country);
}
