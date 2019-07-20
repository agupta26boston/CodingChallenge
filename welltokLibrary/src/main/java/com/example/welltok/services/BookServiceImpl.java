package com.example.welltok.services;

import com.example.welltok.model.Book;
import com.example.welltok.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    @Override
    public List<Book> listAll(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Optional<Book> getById(int id) {
        return bookRepository.findById(id);
    }
    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book, int id) {
        Book newBook = bookRepository.save(book);
        return newBook;

    }

}