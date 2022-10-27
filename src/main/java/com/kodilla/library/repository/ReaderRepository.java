package com.kodilla.library.repository;

import com.kodilla.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Integer> {

    @Override
    Reader save(Reader reader);

    @Override
    List<Reader> findAll();

    @Override
    Optional<Reader> findById(Integer id);

    @Override
    void deleteById(Integer id);
}
