package com.example.crudsteels.controllers;

import com.example.crudsteels.models.Steels;
import com.example.crudsteels.services.SteelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/steels")
public class SteelsController
{
    @Autowired
    SteelService steelService;

    @GetMapping(value = "/steels",
            produces = {"application/json"})
    public ResponseEntity<?> listAllSteels(HttpServletRequest request)
    {
        List<Steels> mySteels = steelService.findAll();
        return new ResponseEntity<>(mySteels, HttpStatus.OK);
    }
}
