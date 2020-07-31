package com.github.ethanbrown3.githubgistsclient.models;

public class GithubUser {
    private String login;
    private Integer public_repos;
    private String bio;
    private String company;
    private String location;

    public GithubUser(String login, int publicRepos, String bio, String company, String location) {
        this.login = login;
        this.public_repos = publicRepos;
        this.bio = bio;
        this.company = company;
        this.location = company;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getPublicRepos() {
        return public_repos;
    }

    public void setPublicRepos(int publicRepos) {
        this.public_repos = publicRepos;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "GithubUser{\n" +
                "login='" + login + '\'' +
                ",\npublic_repos=" + public_repos +
                ",\nbio='" + bio + '\'' +
                ",\ncompany='" + company + '\'' +
                ",\nlocation='" + location +'\'' +
                '}';
    }
}
