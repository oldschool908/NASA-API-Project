package com.github.oldschool908.Project.models;

import java.util.ArrayList;
import java.util.HashMap;

public class NeoResponse {
    private HashMap<String, ArrayList<MeteorFeed>> near_earth_objects;

    public HashMap<String, ArrayList<MeteorFeed>> getNear_earth_objects() {
        return near_earth_objects;
    }
}
