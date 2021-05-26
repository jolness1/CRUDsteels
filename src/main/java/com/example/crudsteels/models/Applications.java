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
    private Set<Steels> steel = new HashSet<>();



    // Set up One to Many relationship with Steel Types once it is set up
    @Column(nullable = false, unique = true)
    private String application;

    public Applications() {
    }

    public Applications(long applicationid, Set<Steels> steel, String application) {
        this.applicationid = applicationid;
        this.steel = steel;
        this.application = application;
    }

    public long getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(long applicationid) {
        this.applicationid = applicationid;
    }

    public Set<Steels> getSteel() {
        return steel;
    }

    public void setSteel(Set<Steels> steel) {
        this.steel = steel;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }


}
