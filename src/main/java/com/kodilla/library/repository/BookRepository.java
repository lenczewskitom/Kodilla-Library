package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

    @Override
    List<Book> findAll();

    @Override
    Optional<Book> findById(Integer id);

    @Override
    Book save(Book book);

    @Override
    void deleteById(Integer id);
}
