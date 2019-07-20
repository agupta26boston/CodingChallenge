package com.example.welltok.controllers;

import java.util.Collections;
import java.util.Optional;

import com.example.welltok.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.welltok.services.*;

@RestController
public class BookController {
    private BookService bookService;

    @RequestMapping(value="/book/list", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<>(bookService.listAll(),HttpStatus.OK);
    }

    @RequestMapping(value="/book/{id}", method = RequestMethod.GET, produces = "application/json")
    public Optional<Book> getBookById(@PathVariable int id){
        Optional<Book> book = bookService.getById(id);
        return book;
    }

    @RequestMapping(value="/book/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        bookService.delete(id);
        return new ResponseEntity<>(Collections.EMPTY_MAP, HttpStatus.OK);
    }

    @RequestMapping(value="/book", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Object> deleteAll() {
        bookService.deleteAll();
        return new ResponseEntity<>(Collections.EMPTY_MAP, HttpStatus.OK);
    }

    @RequestMapping(value="/book/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Object> save(@RequestBody Book book) {
        Book newBook = bookService.save(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity updateBook(@RequestBody Book book, @PathVariable(value ="id") int id) {
        book.setAuthor(book.getAuthor());
        book.setCreate_date(book.getCreate_date());
        book.setDescription(book.getDescription());
        book.setTags(book.getTags());
        book.setTitle(book.getTitle());
        book.setUpdate_date(book.getUpdate_date());
        Book newBook = bookService.save(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

}
