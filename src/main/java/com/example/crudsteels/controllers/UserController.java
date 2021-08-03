package com.example.crudsteels.controllers;


import com.example.crudsteels.models.User;
import com.example.crudsteels.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserService userService;

    // @Get /users - Lists all Users

    @GetMapping(value = "users", produces = "application/json")
    public ResponseEntity<?> listAllUsers(HttpServletRequest request)
    {
        List<User> myUsers = userService.findAll();
        return new ResponseEntity<>(myUsers, HttpStatus.OK);
    }

    // @Get /getuserinfo - returns information about currently authenticated user

    @GetMapping(value = "/getuserinfo",
            produces = {"application/json"})
    public ResponseEntity<?> getCurrentUserInfo(Authentication authentication)
    {
        User u = userService.findByName(authentication.getName());
        return new ResponseEntity<>(u,
                HttpStatus.OK);
    }

// @Post /user - add's new user

    @PostMapping(value = "/user", consumes = "application/json")
    public ResponseEntity<?> addNewUser(
            @Valid
            @RequestBody
                    User newuser) throws URISyntaxException
    {
        newuser.setUserid(0);
        newuser = userService.save(newuser);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand(newuser.getUserid())
                .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null,
                responseHeaders,
                HttpStatus.CREATED);
    }

// @Put /user/{userid} - updates full user (requires all user data points)

    @PutMapping(value = "/user/{userid}",
            consumes = "application/json")
    public ResponseEntity<?> updateFullUser(
            @Valid
            @RequestBody
                    User updateUser,
            @PathVariable
                    long userid)
    {
        updateUser.setUserid(userid);
        userService.save(updateUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

// @Patch /user/{userid} - updates only fields sent

    @PatchMapping(value = "/user/{id}",
            consumes = "application/json")
    public ResponseEntity<?> updateUser(
            @RequestBody
                    User updateUser,
            @PathVariable
                    long id)
    {
        userService.update(updateUser,
                id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

// @Delete /user/{userid} - delete user at given id

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<?> deleteUserById(
            @PathVariable
                    long id)
    {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
