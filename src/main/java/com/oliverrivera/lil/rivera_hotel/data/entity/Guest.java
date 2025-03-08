package com.oliverrivera.lil.rivera_hotel.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity     // @ Entity is used to mark the class as a Java persistence API (JPA) entity. represents a single row in the database.
@Table(name = "guests") // @ Table is used to specify the name of the table that this entity maps to.
@Data   // @ Data is a Lombok annotation that generates getters, setters, toString, and equals methods.
@ToString   // @ ToString is a Lombok annotation that generates a toString method.
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "guest_id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "address")
    private String address;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "phone_number")
    private String phoneNumber;
}
