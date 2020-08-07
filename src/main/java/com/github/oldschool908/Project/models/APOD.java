package com.github.oldschool908.Project.models;

public class APOD {
    private String explanation;
    private String date;
    private String url;
    private String title;

    public String getExplanation() {
        return explanation;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "APOD{" +
                "explanation='" + explanation + '\'' +
                ", date='" + date + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
