package com.example.crudsteels.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SteelIndustrialId implements Serializable
{

    private long steel;

    private long application;

    public SteelIndustrialId()
    {
    }

    public long getSteel()
    {
        return steel;
    }

    public void setSteel(long steel)
    {
        this.steel = steel;
    }

    public long getApplication()
    {
        return application;
    }

    public void setApplication(long application)
    {
        this.application = application;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        SteelIndustrialId that = (SteelIndustrialId) o;
        return steel == that.steel &&
                application == that.application;
    }

    @Override
    public int hashCode()
    {
        return 42;
    }
}
