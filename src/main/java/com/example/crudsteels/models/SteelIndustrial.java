package com.example.crudsteels.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "steelindustrial")
@IdClass(SteelIndustrialId.class)
public class SteelIndustrial
        extends Auditable
        implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "steelid")
    @JsonIgnoreProperties(value = "application", allowSetters = true)
    private Steels steel;

    @Id
    @ManyToOne
    @JoinColumn(name = "applicationid")
    @JsonIgnoreProperties(value = "steel", allowSetters = true)
    private Applications application;

    public SteelIndustrial()
    {
    }

    public SteelIndustrial(Steels steel, Applications applications)
    {
        this.steel = steel;
        this.application = applications;
    }


    public Steels getSteel()
    {
        return steel;
    }

    public void setSteel(Steels steel)
    {
        this.steel = steel;
    }

    public Applications getApplication()
    {
        return application;
    }

    public void setApplication(Applications applications)
    {
        this.application = applications;
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
        return ((steel == null) ? 0 : steel.getSteelid()) == ((that.steel == null) ? 0 : that.steel.getSteelid()) &&
                ((application == null) ? 0 : application.getApplicationid()) == ((that.application == null) ? 0 : that.application.getApplicationid());
    }

    @Override
    public int hashCode()
    {
        return 42;
    }
}
