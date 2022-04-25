package ukim.finki.emt.lab2.service;

import org.springframework.stereotype.Service;
import ukim.finki.emt.lab2.model.Country;


public interface CountryService {
    Country create(String name, String continent);
}
