package com.example.crudsteels.services;

import com.example.crudsteels.models.Steels;

import java.util.List;

public interface SteelService
{

    List<Steels> findAll();

    Steels findSteelById(long steelid);

    Steels findByName(String steelname);

    Steels findByNameContaining(String steelname);

    Steels save(Steels newsteel);

    void update(Steels updateSteel, long steelid);

    void delete(long steelid);

    Steels findByManufacturer(String manufacturer);

//    List<Steels> findSteelById(long id);
}
