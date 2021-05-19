package com.example.crudsteels.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "knifetype")
public class KnifeType extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long knifetypeid;

    // eg Kitchen Knife, Survival Knife, Axe/Machete, Pocket Knife
    // One to many relation to Steels
    @OneToMany(mappedBy = "knifetype", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "knifetype", allowSetters = true)
    private List<SteelKnifeType> steelknifetype = new ArrayList<>();


    private String knifeType;
}
