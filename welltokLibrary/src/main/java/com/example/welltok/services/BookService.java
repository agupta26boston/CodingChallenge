package com.example.welltok.services;

import com.example.welltok.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> listAll();

    void delete(int id);

    void deleteAll();

    Optional<Book> getById(int id);

    Book save(Book book);

    Book updateBook(Book book, int id);

}
