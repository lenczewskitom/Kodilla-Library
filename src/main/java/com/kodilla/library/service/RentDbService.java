package com.kodilla.library.service;

import com.kodilla.library.domain.Rent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentDbService {

    private List<Rent> rents = new ArrayList<>();

    public void rentBook(final Rent rent) {
        rents.add(rent);
    }

    public void returnBook(final Rent rent) {
        rents.remove(rent);
    }
}
