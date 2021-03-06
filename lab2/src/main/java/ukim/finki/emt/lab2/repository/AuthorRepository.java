package ukim.finki.emt.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukim.finki.emt.lab2.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
