package com.kodilla.library.repository;

import com.kodilla.library.domain.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends CrudRepository<Rent, Integer> {
}
