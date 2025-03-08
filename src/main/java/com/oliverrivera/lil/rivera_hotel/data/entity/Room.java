package com.oliverrivera.lil.rivera_hotel.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

/**
 * This class represents a room in the hotel.
 */
@Entity                   // @ Entity is used to mark the class as a Java persistence API (JPA) entity. represents a single row in the database.
@Table(name = "rooms")    // @ Table is used to specify the name of the table that this entity maps to.
@Data                     // @ Data is a Lombok annotation that generates getters, setters, toString, and equals methods.
@ToString                 // @ ToString is a Lombok annotation that generates a toString method.
public class Room {

    @Id                                               // @ Id is used to specify the primary key of the entity.
    @Column(name = "room_id")                         // @ Column is used to specify the column name in the database.
    @GeneratedValue(strategy = GenerationType.AUTO)   // @ GeneratedValue is used to specify the generation strategy for the primary key.
    private long id;

    @Column(name = "name")    // @ Column is used to specify the column name in the database.
    private String name;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "bed_info")
    private String bedInfo;
}
