package com.example.crudsteels.services;

import com.example.crudsteels.models.User;

import java.util.List;

public interface UserService
{
    List<User> findAll();

    List<User> findByNameContaining(String username);

//    User save(User user);
}
