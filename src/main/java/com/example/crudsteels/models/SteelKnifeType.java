package com.example.crudsteels.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "steelknifetype")
public class SteelKnifeType extends Auditable implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "steelid")
    @JsonIgnoreProperties("steelknifetype")
    private Steels steels;

    @Id
    @ManyToOne
    @JoinColumn(name = "knifetypeid")
    @JsonIgnoreProperties("steelknifetype")
    private KnifeType knifetype;

    public SteelKnifeType() {
    }

    public SteelKnifeType(Steels steels, KnifeType knifetype) {
        this.steels = steels;
        this.knifetype = knifetype;
    }

    public Steels getSteels() {
        return steels;
    }

    public void setSteels(Steels steels) {
        this.steels = steels;
    }

    public KnifeType getKnifetype() {
        return knifetype;
    }

    public void setKnifetype(KnifeType knifeType) {
        this.knifetype = knifeType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof SteelKnifeType))
        {
            return false;
        }
        SteelKnifeType that = (SteelKnifeType) obj;
        return ((steels == null) ? 0 : steels.getSteelid()) == ((that.steels == null) ? 0 : that.steels.getSteelid()) &&
                ((knifetype == null) ? 0 : knifetype.getKnifetypeid()) == ((that.knifetype == null) ? 0 : that.knifetype.getKnifetypeid());
    }
}
