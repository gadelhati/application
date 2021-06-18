package com.institutohidrografico.application.controller;

import com.institutohidrografico.application.persistence.model.Book;
import com.institutohidrografico.application.persistence.repository.BookRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookController extends GenericController<Book> {

    public BookController(BookRepository bookRepository) {
        super(bookRepository);
    }
}