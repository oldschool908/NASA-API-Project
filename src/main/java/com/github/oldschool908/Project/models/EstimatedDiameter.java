package com.github.oldschool908.Project.models;

public class EstimatedDiameter {
    private EstimatedDiameterMinMax feet;

    public EstimatedDiameterMinMax getFeet() {
        return feet;
    }

    @Override
    public String toString() {
        return " " +
                 feet;
    }
}
