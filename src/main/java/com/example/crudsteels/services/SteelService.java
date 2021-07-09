package com.example.crudsteels.services;

import com.example.crudsteels.models.Steels;

import java.util.List;

public interface SteelService
{

    List<Steels> findAll();

    Steels findSteelById(Long steelid);

    Steels findByName(String steelName);

    Steels findByNameContaining(String steelName);

    Steels save(Steels newsteel);

    void update(Steels updateSteel, long steelid);

    void delete(long steelid);

//    List<Steels> findSteelById(long id);
}
