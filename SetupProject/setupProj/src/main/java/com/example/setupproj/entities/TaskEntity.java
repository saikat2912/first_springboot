package com.example.setupproj.entities;

import lombok.Data;

import java.util.Date;

@Data
public class TaskEntity {

    //If we give data class mapping it will generate getter and setter for every field

    private int id;
    private String title;
    private String description;
    private Date deadline;
    private boolean completed;
}
