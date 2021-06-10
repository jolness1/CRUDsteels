package com.example.crudsteels.services;

import com.example.crudsteels.exceptions.ResourceNotFoundException;
import com.example.crudsteels.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "securityUserService")
public class SecurityUserServiceImpl
    implements UserDetailsService
{
    @Autowired
    private UserRepository userrepos;

    @Override
    public UserDetails loadUserByUsername(String s) throws ResourceNotFoundException
    {
        return null;
    }
}
