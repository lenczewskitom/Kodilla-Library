package com.kodilla.library.service;

import com.kodilla.library.controller.BookNotAvailableException;
import com.kodilla.library.controller.BookNotFoundException;
import com.kodilla.library.controller.RentNotFoundException;
import com.kodilla.library.domain.Rent;
import com.kodilla.library.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RentDbService {

    @Autowired
    private final RentRepository rentRepository;
    @Autowired
    private final BookDbService bookDbService;

    @Autowired
    private final TitleDbService titleDbService;

    public List<Rent> getRents() {return rentRepository.findAll(); }

    public void rentBook(final Rent rent) throws BookNotFoundException, BookNotAvailableException {

        if (titleDbService.getAvailableBooks(rent.getBook().getTitle().getTitle()) > 0) {
            bookDbService.changeStatus(rent.getBook().getId(), "Rented");

            rentRepository.save(rent);
        } else throw new BookNotAvailableException();

    }

    public Rent returnBook(final Rent rent) throws RentNotFoundException, BookNotFoundException {

        Rent returned = rentRepository.findById(rent.getRentId()).orElseThrow(RentNotFoundException::new);
        returned.setReturnDate(rent.getReturnDate());
        rentRepository.save(returned);

        bookDbService.changeStatus(rent.getBook().getId(), "Available");

        return returned;
    }
}
