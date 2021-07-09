package com.example.crudsteels.services;


import com.example.crudsteels.models.Steels;
import com.example.crudsteels.repositories.ApplicationsRepository;
import com.example.crudsteels.repositories.KnifeTypeRepository;
import com.example.crudsteels.repositories.SteelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("steelService")
public class SteelServiceImpl implements SteelService
{

    @Autowired
    SteelsRepository steelsRepos;

    @Autowired
    KnifeTypeRepository knifeTypeRepos;

    @Autowired
    ApplicationsRepository applicationsRepos;

    @Override
    public List<Steels> findAll()
    {
        List<Steels> list = new ArrayList<>();
        steelsRepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Steels findSteelById(Long steelid)
    {
        return null;
    }

    @Override
    public Steels findByName(String steelName)
    {
        return null;
    }

    @Override
    public Steels findByNameContaining(String steelName)
    {
        return null;
    }

    @Override
    public Steels save(Steels newsteel)
    {
        return null;
    }

    @Override
    public void update(Steels updateSteel, long steelid)
    {

    }

    @Override
    public void delete(long steelid)
    {

    }

    @Override
    public Steels findByManufacturer(String manufacturer)
    {
        return null;
    }

//    @Override
//    public List<Steels> findSteelById(long id) {
//        Steels currentSteel = steelsRepos.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Steel with ID " + id + "not found!"));
//        return currentSteel;
//    }
}
