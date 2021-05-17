package com.example.crudsteels.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SteelIndustrialId implements Serializable {

    private long steels;

    private long applications;

    public SteelIndustrialId() {
    }

    public long getSteels() {
        return steels;
    }

    public void setSteels(long steels) {
        this.steels = steels;
    }

    public long getApplications() {
        return applications;
    }

    public void setApplications(long applications) {
        this.applications = applications;
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
        return steels == that.steels &&
                applications == that.applications;
    }

    @Override
    public int hashCode()
    {
        return 42;
    }
}
