package com.kodilla.library.repository;

import com.kodilla.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Integer> {

    @Override
    Reader save(Reader reader);

    @Override
    List<Reader> findAll();

    @Override
    void deleteById(Integer id);
}
