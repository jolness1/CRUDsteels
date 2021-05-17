package com.example.crudsteels.models;


import javax.persistence.*;

@Entity
@Table(name = "knifetype")
public class KnifeType extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long knifeTypeid;

    // eg Kitchen Knife, Survival Knife, Axe/Machete, Pocket Knife
    // One to many relation to Steels
    private String knifeType;
}
