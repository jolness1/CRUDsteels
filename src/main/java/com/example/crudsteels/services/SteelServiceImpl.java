package com.example.crudsteels.services;


import com.example.crudsteels.exceptions.ResourceNotFoundException;
import com.example.crudsteels.models.Steels;
import com.example.crudsteels.repositories.ApplicationsRepository;
import com.example.crudsteels.repositories.KnifeTypeRepository;
import com.example.crudsteels.repositories.SteelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
    public Steels findSteelById(long steelid) throws ResourceNotFoundException
    {
        return steelsRepos.findById(steelid)
                .orElseThrow(() -> new ResourceNotFoundException("Steel with id #" + steelid + " not found!"));
    }

    @Override
    public Steels findByName(String steelname)
    {
        Steels steels = steelsRepos.findBySteelname(steelname.toLowerCase());
        if (steels == null)
        {
            throw new ResourceNotFoundException("Steel " + steelname + "not found!");
        }
        return steels;
    }

    @Override
    public Steels findByNameContaining(String steelname)
    {
        return steelsRepos.findBySteelnameContainingIgnoreCase(steelname.toLowerCase());
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
        steelsRepos.findById(steelid)
                .orElseThrow(() -> new ResourceNotFoundException("Steel with id " + steelid + " not found!"));
    }

    @Override
    public Steels findByManufacturer(String manufacturer)
    {
        Steels steels = steelsRepos.findByManufacturer(manufacturer.toLowerCase());
        if (steels == null)
        {
            throw new ResourceNotFoundException("Manufacturer " + manufacturer + "not found!");
        }
        return steels;
    }

}
