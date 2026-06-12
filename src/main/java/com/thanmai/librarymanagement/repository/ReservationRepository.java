package com.thanmai.librarymanagement.repository;

import com.thanmai.librarymanagement.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByUserUserId(Long userId);
}