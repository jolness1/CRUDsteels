package com.example.crudsteels.models;

import javax.persistence.*;

@Entity
@Table(name = "steelknifetype")
public class SteelKnifeType extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long steelknifetypeid;

    @Column(nullable = false)
    private String steelknifetype;
}
