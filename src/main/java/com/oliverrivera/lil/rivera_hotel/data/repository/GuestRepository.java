package com.oliverrivera.lil.rivera_hotel.data.repository;

import com.oliverrivera.lil.rivera_hotel.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
