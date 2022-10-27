package com.kodilla.library.repository;

import com.kodilla.library.domain.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentRepository extends CrudRepository<Rent, Integer> {

    @Override
    List<Rent> findAll();

    @Override
    Optional<Rent> findById(Integer id);

    @Override
    Rent save(Rent rent);

    @Override
    void deleteById(Integer id);
}
