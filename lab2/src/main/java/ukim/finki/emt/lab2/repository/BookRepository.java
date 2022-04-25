package ukim.finki.emt.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukim.finki.emt.lab2.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    void deleteById(Long id);
    void deleteByName(String name);
}
