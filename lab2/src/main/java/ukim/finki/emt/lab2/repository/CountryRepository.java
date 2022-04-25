package ukim.finki.emt.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukim.finki.emt.lab2.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
