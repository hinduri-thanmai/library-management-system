package com.thanmai.librarymanagement.service;

import com.thanmai.librarymanagement.dto.ReservationDTO;
import com.thanmai.librarymanagement.entity.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation reserveBook(ReservationDTO reservationDTO);

    List<Reservation> getUserReservations(Long userId);
}