package com.example.knowurcompany.company;


import com.example.knowurcompany.review.Reviews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "COMPANY")
public class Company {


    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private int noOfEmployees;

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Reviews> reviews;
    private String founder;

    public Company(Long id, String name, String address, int noOfEmployees, String founder) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.noOfEmployees = noOfEmployees;
        this.founder = founder;
    }

    public Company() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setNoOfEmployees(int noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }
}
