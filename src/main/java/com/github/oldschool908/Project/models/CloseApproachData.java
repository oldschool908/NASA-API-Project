package com.github.oldschool908.Project.models;

public class CloseApproachData {
    private String close_approach_date;
    private RelativeVelocity speed;
    private MissDistance miss_distance;

    public MissDistance getMissDistance() {
        return miss_distance;
    }

    public RelativeVelocity getSpeed() {
        return speed;
    }

    public String getClose_approach_date() {
        return close_approach_date;
    }

    @Override
    public String toString() {
        return "Date: " + close_approach_date + "\n"
                + "Relative Velocity: " + speed +"\n"
                + "Miss Distance: " + miss_distance +"\n";
    }


    public String toStringSpeed() {
        return " " +
                speed ;
    }
}
