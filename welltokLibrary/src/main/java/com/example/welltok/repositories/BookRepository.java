package com.example.welltok.repositories;


import com.example.welltok.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Integer> {


}
