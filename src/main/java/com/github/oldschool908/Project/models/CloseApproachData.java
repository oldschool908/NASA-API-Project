package com.github.oldschool908.Project.models;

import java.util.ArrayList;

public class CloseApproachData {
    private String close_approach_date;
    private RelativeVelocity relative_velocity;
    private MissDistance miss_distance;

    public MissDistance getMissDistance() {
        return miss_distance;
    }

    public RelativeVelocity getSpeed() {
        return relative_velocity;
    }

    public String getClose_approach_date() {
        return close_approach_date;
    }

    @Override
    public String toString() {
        return "\nDate: " + close_approach_date + "\n"
                + "Relative Velocity: " + relative_velocity +"\n"
                + "Miss Distance: " + miss_distance +"\n";
    }


    public String toStringSpeed() {
        return " " +
                relative_velocity ;
    }
}
