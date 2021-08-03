package com.example.crudsteels.services;

import com.example.crudsteels.models.User;

import java.util.List;

public interface UserService
{
    List<User> findAll();

    User findByName(String name);

    User save(User newuser);

    User update(User updateUser, long id);

    void delete(long id);

}
