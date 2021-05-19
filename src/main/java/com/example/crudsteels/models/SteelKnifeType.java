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
    private KnifeType knifeType;

    public SteelKnifeType() {
    }

    public SteelKnifeType(Steels steels, KnifeType knifeType) {
        this.steels = steels;
        this.knifeType = knifeType;
    }

    public Steels getSteels() {
        return steels;
    }

    public void setSteels(Steels steels) {
        this.steels = steels;
    }

    public KnifeType getKnifeType() {
        return knifeType;
    }

    public void setKnifeType(KnifeType knifeType) {
        this.knifeType = knifeType;
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
                ((knifeType == null) ? 0 : knifeType.getKnifetypeid()) == ((that.knifeType == null) ? 0 : that.knifeType.getKnifetypeid());
    }
}
