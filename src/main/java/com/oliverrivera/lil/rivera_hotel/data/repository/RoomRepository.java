package com.oliverrivera.lil.rivera_hotel.data.repository;

import com.oliverrivera.lil.rivera_hotel.data.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// This interface extends the JpaRepository interface and provides a method to find a room by its room number.
public interface RoomRepository extends JpaRepository<Room, Long> {
    // This method finds a room by its room number.
    Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);
}
