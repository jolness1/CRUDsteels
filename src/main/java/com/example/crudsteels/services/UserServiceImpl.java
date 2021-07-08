package com.example.crudsteels.services;

import com.example.crudsteels.exceptions.ResourceNotFoundException;
import com.example.crudsteels.models.Role;
import com.example.crudsteels.models.User;
import com.example.crudsteels.models.UserRoles;
import com.example.crudsteels.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepository userRepos;

    @Override
    public List<User> findAll()
    {
        List<User> list = new ArrayList<>();
        userRepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<User> findByNameContaining(String username)
    {
        return null;
    }
}
