package ukim.finki.emt.lab2.service.impl;

import org.springframework.stereotype.Service;
import ukim.finki.emt.lab2.model.Country;
import ukim.finki.emt.lab2.repository.CountryRepository;
import ukim.finki.emt.lab2.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country create(String name, String continent) {
        Country country = new Country(name, continent);
        return this.countryRepository.save(country);
    }
}
