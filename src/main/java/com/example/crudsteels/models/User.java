package com.example.crudsteels.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import javax.validation.constraints.Email;

@Entity
@Table(name = "user")
public class User extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false, unique = true)
    @Email
    private String useremail
}
