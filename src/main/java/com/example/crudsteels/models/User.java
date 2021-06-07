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
    private String useremail;

    public User()
    {
    }

    public User(long userid, String username, String password, String useremail)
    {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.useremail = useremail;
    }

    public long getUserid()
    {
        return userid;
    }

    public void setUserid(long userid)
    {
        this.userid = userid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUseremail()
    {
        return useremail;
    }

    public void setUseremail(String useremail)
    {
        this.useremail = useremail;
    }
}


