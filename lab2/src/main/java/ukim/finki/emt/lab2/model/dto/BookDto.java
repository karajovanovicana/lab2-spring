package ukim.finki.emt.lab2.model.dto;

import lombok.Data;
import ukim.finki.emt.lab2.enumeration.Category;
import ukim.finki.emt.lab2.model.Author;

import javax.persistence.*;

@Data
public class BookDto {
    String name;
    @Enumerated(EnumType.STRING)
    Category category;
    Long author;
    Integer availableCopies;

    public BookDto(String name, Category category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public BookDto() {
    }
}
