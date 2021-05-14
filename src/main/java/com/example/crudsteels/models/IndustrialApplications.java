package com.example.crudsteels.models;


import javax.persistence.*;

@Entity
@Table(name = "application")
public class IndustrialApplications {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long applicationid;


    // Set up One to Many relationship with Steel Types once it is set up
    private String application;
}
