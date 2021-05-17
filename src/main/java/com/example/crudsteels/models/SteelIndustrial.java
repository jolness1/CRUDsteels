package com.example.crudsteels.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "steelindustrial")
@IdClass(SteelIndustrialId.class)
public class SteelIndustrial
            extends Auditable
            implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "steelid")
    private Steels steels;

    @Id
    @ManyToOne
    @JoinColumn(name = "applicationid")
    private Applications applications;

    public SteelIndustrial() {
    }

    public SteelIndustrial(Steels steels, Applications applications) {
        this.steels = steels;
        this.applications = applications;
    }


    public Steels getSteels() {
        return steels;
    }

    public void setSteels(Steels steels) {
        this.steels = steels;
    }

    public Applications getApplications() {
        return applications;
    }

    public void setApplications(Applications applications) {
        this.applications = applications;
    }


    // user = steels
    // role = applications;
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof SteelIndustrial))
        {
            return false;
        }
        SteelIndustrial that = (SteelIndustrial) o;
        return ((steels == null) ? 0 : steels.getSteelid()) == ((that.steels == null) ? 0 : that.steels.getSteelid()) &&
                ((applications == null) ? 0 : applications.getApplicationid()) == ((that.applications == null) ? 0 : that.applications.getApplicationid());
    }

    @Override
    public int hashCode()
    {
        return 42;
    }
}
