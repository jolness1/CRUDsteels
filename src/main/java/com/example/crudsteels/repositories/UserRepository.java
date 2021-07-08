package com.example.crudsteels.repositories;

import com.example.crudsteels.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String Username);
}
