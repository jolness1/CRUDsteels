package com.example.crudsteels.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "application")
public class Applications extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long applicationid;

    @OneToMany(mappedBy = "applications",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "applications", allowSetters = true)
    private Set<SteelIndustrial> steels = new HashSet<>();



    // Set up One to Many relationship with Steel Types once it is set up
    @Column(nullable = false, unique = true)
    private String application;

    public Applications() {
    }

    public Applications(long applicationid, String application) {
        this.applicationid = applicationid;
        this.application = application;
    }

    public long getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(long applicationid) {
        this.applicationid = applicationid;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }
}
