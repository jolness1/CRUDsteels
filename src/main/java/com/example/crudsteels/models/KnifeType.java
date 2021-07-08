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
    private List<Steels> steel = new ArrayList<>();


    private String knifetype;

    public KnifeType()
    {
    }

    public KnifeType(long knifetypeid, List<Steels> steel, String knifetype)
    {
        this.knifetypeid = knifetypeid;
        this.steel = steel;
        this.knifetype = knifetype;
    }

    public long getKnifetypeid()
    {
        return knifetypeid;
    }

    public void setKnifetypeid(long knifetypeid)
    {
        this.knifetypeid = knifetypeid;
    }

    public List<Steels> getSteel()
    {
        return steel;
    }

    public void setSteel(List<Steels> steel)
    {
        this.steel = steel;
    }

    public String getKnifetype()
    {
        return knifetype;
    }

    public void setKnifetype(String knifeType)
    {
        this.knifetype = knifeType;
    }
}
