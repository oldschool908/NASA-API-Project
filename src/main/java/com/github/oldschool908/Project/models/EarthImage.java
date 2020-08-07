package com.github.oldschool908.Project.models;

import javafx.scene.image.Image;

public class EarthImage {
    private String url;
    private String lat;
    private String lon;
    private String date;
    private Image imageEI;

    public Image getImageEI() {
        return imageEI;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }



    @Override
    public String toString() {
        return "EarthImage{" +
                "url='" + url +
                '\''+ '}';
    }

//    @Override
//    public String toString() {
//        return "EarthImage{" +
//                "lon='" + lon + '\'' +
//                ", lat='" + lat + '\'' +
//                ", url='" + url + '\'' +
//                ", date='" + date + '\'' +
//                '}';
//    }
}
