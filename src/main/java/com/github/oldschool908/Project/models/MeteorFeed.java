package com.github.oldschool908.Project.models;

import java.util.ArrayList;

public class MeteorFeed {
    private String id;
    private String name;
    private String nasa_jpl_url;
    private Double absolute_magnitude_h;
    private EstimatedDiameter estimated_diameter;
    private boolean hazardous;
    private ArrayList<CloseApproachData> close_approach_data;
    private ArrayList<CloseApproachData> relativeVelocityMPH;
    private ArrayList<CloseApproachData> missDistanceMiles;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNasa_jpl_url() {
        return nasa_jpl_url;
    }

    public Double getAbsolute_magnitude_h() {
        return absolute_magnitude_h;
    }

    public EstimatedDiameter getEstimated_diameter() {
        return estimated_diameter;
    }

    public boolean isHazardous() {
        return hazardous;
    }

    public ArrayList<CloseApproachData> getClose_approach_data() {
        return close_approach_data;
    }

    public ArrayList<CloseApproachData> getRelativeVelocityMPH() {
        return relativeVelocityMPH;
    }

    public ArrayList<CloseApproachData> getMissDistanceMiles() {
        return missDistanceMiles;
    }

    @Override
    public String toString() {
        return "MeteorFeed" + '\n' +
                "id= " + id + '\n' +
                "name= " + name + '\n' +
                "nasa_jpl_url= " + nasa_jpl_url + '\n' +
                "absolut_magnitude_h= " + absolute_magnitude_h+ '\n'  +
                "estimated_diameter= " + estimated_diameter+ '\n'  +
                "hazardous= " + hazardous+ '\n'  +
                "closeApproachDate= " + close_approach_data + '\n' +
                "relativeVelocityMPH= " + relativeVelocityMPH+ '\n' +
                "missDistanceMiles= " + missDistanceMiles + '\n';
    }
}
