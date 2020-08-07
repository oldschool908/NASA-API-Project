package com.github.oldschool908.Project.models;

public class EstimatedDiameterMinMax {
    private Double estimated_diameter_min;
    private Double estimated_diameter_max;

    public Double getEstimated_diameter_min() {
        return estimated_diameter_min;
    }

    public Double getEstimated_diameter_max() {
        return estimated_diameter_max;
    }

    @Override
    public String toString() {
        return "Estimated Diameter Min = " + estimated_diameter_min +"ft"+ "\n"
                + "Estimated Diameter Max = " + estimated_diameter_max +"ft"
                ;
    }
}
