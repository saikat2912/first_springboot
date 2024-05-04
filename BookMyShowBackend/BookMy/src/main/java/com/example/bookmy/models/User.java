package com.example.bookmy.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseModel {
    private String email;
    private String name;
    private String password;
    @OneToMany
    private List<Booking> bookings;
}
