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
    @OneToMany(mappedBy = "knifeType", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "knifeType", allowSetters = true)
    private List<SteelKnifeType> steelknifetype = new ArrayList<>();


    private String knifeType;

    public KnifeType() {
    }

    public KnifeType(long knifetypeid, List<SteelKnifeType> steelknifetype, String knifeType) {
        this.knifetypeid = knifetypeid;
        this.steelknifetype = steelknifetype;
        this.knifeType = knifeType;
    }

    public long getKnifetypeid() {
        return knifetypeid;
    }

    public void setKnifetypeid(long knifetypeid) {
        this.knifetypeid = knifetypeid;
    }

    public List<SteelKnifeType> getSteelknifetype() {
        return steelknifetype;
    }

    public void setSteelknifetype(List<SteelKnifeType> steelknifetype) {
        this.steelknifetype = steelknifetype;
    }

    public String getKnifeType() {
        return knifeType;
    }

    public void setKnifeType(String knifeType) {
        this.knifeType = knifeType;
    }
}
