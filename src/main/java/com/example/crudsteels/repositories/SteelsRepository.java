package com.example.crudsteels.repositories;

import com.example.crudsteels.models.Steels;
import org.springframework.data.repository.CrudRepository;

public interface SteelsRepository extends CrudRepository<Steels, Long>
{
    Steels findBySteelname(String steelname);

    Steels findBySteelnameContainingIgnoreCase(String toLowerCase);

    Steels findByManufacturer(String toLowerCase);
}
