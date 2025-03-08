package com.oliverrivera.lil.rivera_hotel.data.repository;

import com.oliverrivera.lil.rivera_hotel.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByReservationDate(Date date);
}
