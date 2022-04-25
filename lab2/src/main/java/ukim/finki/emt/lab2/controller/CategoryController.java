package ukim.finki.emt.lab2.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ukim.finki.emt.lab2.enumeration.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "https://library-emt-react.herokuapp.com/")
@RequestMapping("/api/categories")
public class CategoryController {

    @GetMapping
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.addAll(Arrays.asList(Category.values()));
        return categoryList;
    }
}