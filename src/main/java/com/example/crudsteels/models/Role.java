package com.example.crudsteels.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleid;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "role",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties(value = "role",
    allowSetters = true)
    private Set<UserRoles> users = new HashSet<>();

    public Role()
    {
    }

    public Role(long roleid, String name, Set<UserRoles> users)
    {
        this.roleid = roleid;
        this.name = name;
        this.users = users;
    }

    public long getRoleid()
    {
        return roleid;
    }

    public void setRoleid(long roleid)
    {
        this.roleid = roleid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name.toUpperCase();
    }

    public Set<UserRoles> getUsers()
    {
        return users;
    }

    public void setUsers(Set<UserRoles> users)
    {
        this.users = users;
    }
}
