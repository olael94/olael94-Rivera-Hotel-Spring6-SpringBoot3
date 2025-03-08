package com.oliverrivera.lil.rivera_hotel.service;

import com.oliverrivera.lil.rivera_hotel.data.entity.Guest;
import com.oliverrivera.lil.rivera_hotel.data.entity.Reservation;
import com.oliverrivera.lil.rivera_hotel.data.entity.Room;
import com.oliverrivera.lil.rivera_hotel.data.repository.GuestRepository;
import com.oliverrivera.lil.rivera_hotel.data.repository.ReservationRepository;
import com.oliverrivera.lil.rivera_hotel.data.repository.RoomRepository;
import com.oliverrivera.lil.rivera_hotel.service.model.RoomReservation;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * This class was created to build a service abstraction to get room reservations for a given date.
 */
@Service        // This allows injection of this class into other classes.
public class RoomReservationService {
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    public RoomReservationService(GuestRepository guestRepository, RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(String reservationDate) {
        Date date = null;

        // If the reservation date is provided, convert it to a Date object.
        if (StringUtils.isNotEmpty(reservationDate)) {
            date = Date.valueOf(reservationDate);
        } else {
            // If the date is not provided, use the current date.
            date = new Date(new java.util.Date().getTime());
        }

        // Get all the reservations for the provided date.
        Map<Long, RoomReservation> roomReservations = new HashMap<>();
        List<Room> rooms = this.roomRepository.findAll();

        // Create a RoomReservation object for each room.
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservations.put(roomReservation.getRoomId(), roomReservation);
        });

        // Once we have the reservations, we can populate the RoomReservation objects with the reservation details.
        List<Reservation> reservations = this.reservationRepository.findAllByReservationDate(date);

        // For each reservation, get the guest details and populate the RoomReservation object.
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservations.get(reservation.getRoomId());
            roomReservation.setReservationId(reservation.getId());
            roomReservation.setReservationDate(reservation.getReservationDate().toString());
            Optional<Guest> guest = this.guestRepository.findById(reservation.getGuestId());
            roomReservation.setGuestId(guest.get().getId());
            roomReservation.setFirstName(guest.get().getFirstName());
            roomReservation.setLastName(guest.get().getLastName());
        });

        // Return the list of RoomReservation objects.
        return roomReservations.values().stream().toList();
    }
}
