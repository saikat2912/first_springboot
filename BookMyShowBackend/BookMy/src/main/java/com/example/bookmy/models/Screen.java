package com.example.bookmy.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;
    @OneToMany
    private List<Seat> seats;
    //Element collection means it is a list of enum
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
