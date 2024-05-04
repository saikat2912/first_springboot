package com.example.bookmy.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private Date dateReleased;
    @ElementCollection
    private List<Feature> features;
}
