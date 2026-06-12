package com.thanmai.librarymanagement.controller;

import com.thanmai.librarymanagement.dto.ReservationDTO;
import com.thanmai.librarymanagement.entity.Reservation;
import com.thanmai.librarymanagement.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/add")
    public Reservation reserveBook(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.reserveBook(reservationDTO);
    }

    @GetMapping("/user/{userId}")
    public List<Reservation> getUserReservations(@PathVariable Long userId) {
        return reservationService.getUserReservations(userId);
    }
}