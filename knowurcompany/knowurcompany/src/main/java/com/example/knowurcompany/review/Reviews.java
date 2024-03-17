package com.example.knowurcompany.review;


import com.example.knowurcompany.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "REVIEWS")
public class Reviews {

    @Id
    @GeneratedValue
    private Long id;



    @ManyToOne
    @JsonIgnore
    private Company company;


    private String review;

    private String username;

    public Reviews(Long id, Company company, String review, String username) {
        this.id = id;
        this.company = company;
        this.review = review;
        this.username = username;
    }


    public Reviews() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
