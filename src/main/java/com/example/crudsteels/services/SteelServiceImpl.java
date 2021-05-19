package com.example.crudsteels.services;


import com.example.crudsteels.models.Steels;
import com.example.crudsteels.repositories.ApplicationsRepository;
import com.example.crudsteels.repositories.KnifeTypeRepository;
import com.example.crudsteels.repositories.SteelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("steelService")
public class SteelServiceImpl implements SteelService {

    @Autowired
    SteelsRepository steelsRepos;

    @Autowired
    KnifeTypeRepository knifeTypeRepos;

    @Autowired
    ApplicationsRepository applicationsRepos;

    @Override
    public List<Steels> findAll(){
        List<Steels> list = new ArrayList<>();
        steelsRepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }
}