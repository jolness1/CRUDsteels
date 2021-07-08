package com.example.crudsteels.services;

import com.example.crudsteels.exceptions.ResourceNotFoundException;
import com.example.crudsteels.models.User;
import com.example.crudsteels.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Transactional
@Service(value = "securityUserService")
public class SecurityUserServiceImpl
    implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        User user = userRepository.findByUsername(s.toLowerCase());
        if (user == null)
        {
            throw new ResourceNotFoundException("Invalid Username or Password.");
        }
        return new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), user.getAuthority());

    }
}
