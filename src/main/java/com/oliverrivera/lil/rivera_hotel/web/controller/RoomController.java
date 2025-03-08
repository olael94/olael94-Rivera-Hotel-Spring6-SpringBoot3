package com.oliverrivera.lil.rivera_hotel.web.controller;


import com.oliverrivera.lil.rivera_hotel.data.repository.RoomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public String getRooms(Model model) {
        model.addAttribute("rooms", this.roomRepository.findAll());
        return "room-list";
    }
}
