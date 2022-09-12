package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{
}
