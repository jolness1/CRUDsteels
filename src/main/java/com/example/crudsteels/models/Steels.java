package com.example.crudsteels.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "steel")
public class Steels extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long steelid;

    @ManyToOne
    @JoinColumn(name = "applicationid", nullable = false)
    @JsonIgnoreProperties(value = "steel", allowSetters = true)
    private Applications applications;

    @ManyToOne
    @JoinColumn(name = "knifetypeid", nullable = false)
    @JsonIgnoreProperties(value = "steel", allowSetters = true)
    private KnifeType knifetype;

    // eg 420HC, s30v, m390
    private String steelname;

    // Crucible, Carpenter, Böhler-Uddeholm
    private String manufacturer;

    private String steeldescription;

    // Hardness range in HRC
    private String rockwellhardness;

    // 1 - 10 Scale
    private String sharpening;

    // 1 - 10 Scale
    private String edgeretention;

    // 1 - 10 Scale
    private String stainless;

    public Steels() {
    }

    public Steels(long steelid, Applications applications, KnifeType knifetype, String steelname, String manufacturer, String steeldescription, String rockwellhardness, String sharpening, String edgeretention, String stainless) {
        this.steelid = steelid;
        this.applications = applications;
        this.knifetype = knifetype;
        this.steelname = steelname;
        this.manufacturer = manufacturer;
        this.steeldescription = steeldescription;
        this.rockwellhardness = rockwellhardness;
        this.sharpening = sharpening;
        this.edgeretention = edgeretention;
        this.stainless = stainless;
    }

    public long getSteelid() {
        return steelid;
    }

    public void setSteelid(long steelid) {
        this.steelid = steelid;
    }

    public Applications getApplications() {
        return applications;
    }

    public void setApplications(Applications applications) {
        this.applications = applications;
    }

    public KnifeType getKnifetype() {
        return knifetype;
    }

    public void setKnifetype(KnifeType knifetype) {
        this.knifetype = knifetype;
    }

    public String getSteelname() {
        return steelname;
    }

    public void setSteelname(String steelname) {
        this.steelname = steelname;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSteeldescription() {
        return steeldescription;
    }

    public void setSteeldescription(String steeldescription) {
        this.steeldescription = steeldescription;
    }

    public String getRockwellhardness() {
        return rockwellhardness;
    }

    public void setRockwellhardness(String rockwellhardness) {
        this.rockwellhardness = rockwellhardness;
    }

    public String getSharpening() {
        return sharpening;
    }

    public void setSharpening(String sharpening) {
        this.sharpening = sharpening;
    }

    public String getEdgeretention() {
        return edgeretention;
    }

    public void setEdgeretention(String edgeretention) {
        this.edgeretention = edgeretention;
    }

    public String getStainless() {
        return stainless;
    }

    public void setStainless(String stainless) {
        this.stainless = stainless;
    }

    @Override
    public int hashCode()
    {
        return 42;
    }
}
