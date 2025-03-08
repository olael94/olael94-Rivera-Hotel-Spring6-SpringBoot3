package com.oliverrivera.lil.rivera_hotel.web.controller;

import com.oliverrivera.lil.rivera_hotel.service.RoomReservationService;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/occupancy")
public class OccupancyController {
    /**
     * service variable will be used to access the RoomReservationService class
     */
    private final RoomReservationService service;

    // Constructor with RoomReservationService parameter
    public OccupancyController(RoomReservationService service) {
        this.service = service;
    }

    @GetMapping
    // Method to handle GET requests for occupancy, with an optional date parameter
    public String getOccupancy(Model model, @RequestParam(value="date", required=false) String dateString) {
        // Initialize date variable with current date
        Date date = new Date();

        // Check if dateString is not empty
        if (StringUtils.isNotBlank(dateString)){
            try {
                // Parse the dateString into a Date object using the specified format
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                date = format.parse(dateString);
            } catch (Exception e){
                // If parsing fails, do nothing and keep the current date
            }
        }
        // Add the date to the model
        model.addAttribute("date", date);
        // Add the room reservations for the specified date to the model
        model.addAttribute("reservations", this.service.getRoomReservationsForDate(dateString));

        // Return the occupancy template
        return "occupancy-list";
    }
}
