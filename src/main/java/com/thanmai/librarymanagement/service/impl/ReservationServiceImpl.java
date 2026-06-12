package com.thanmai.librarymanagement.service.impl;

import com.thanmai.librarymanagement.dto.ReservationDTO;
import com.thanmai.librarymanagement.entity.Book;
import com.thanmai.librarymanagement.entity.Reservation;
import com.thanmai.librarymanagement.entity.User;
import com.thanmai.librarymanagement.enums.ReservationStatus;
import com.thanmai.librarymanagement.repository.BookRepository;
import com.thanmai.librarymanagement.repository.ReservationRepository;
import com.thanmai.librarymanagement.repository.UserRepository;
import com.thanmai.librarymanagement.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Reservation reserveBook(ReservationDTO reservationDTO) {

        User user = userRepository.findById(reservationDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Book book = bookRepository.findById(reservationDTO.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setBook(book);
        reservation.setReservationDate(LocalDate.now());
        reservation.setStatus(ReservationStatus.PENDING);

        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getUserReservations(Long userId) {
        return reservationRepository.findByUserUserId(userId);
    }
}