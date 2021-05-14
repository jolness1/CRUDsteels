package com.example.crudsteels.models;


import javax.persistence.*;

@Entity
@Table(name = "knifetype")
public class KnifeType
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long knifetypeid;

    // eg Kitchen Knife, Survival Knife, Axe/Machete, Pocket Knife
    private String knifetype;
}
