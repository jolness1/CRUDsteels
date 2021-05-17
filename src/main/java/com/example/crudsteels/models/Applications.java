package com.example.crudsteels.models;


import javax.persistence.*;

@Entity
@Table(name = "application")
public class Applications extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long applicationid;


    // Set up One to Many relationship with Steel Types once it is set up
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
