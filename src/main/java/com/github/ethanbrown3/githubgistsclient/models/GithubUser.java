package com.github.ethanbrown3.githubgistsclient.models;

public class GithubUser {
    private String login;
    private int publicRepos;
    private String bio;
    private String company;

    public GithubUser(String login, int publicRepos, String bio, String company) {
        this.login = login;
        this.publicRepos = publicRepos;
        this.bio = bio;
        this.company = company;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(int publicRepos) {
        this.publicRepos = publicRepos;
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

    @Override
    public String toString() {
        return "GithubUser{\n" +
                "login='" + login + '\'' +
                ",\npublicRepos=" + publicRepos +
                ",\nbio='" + bio + '\'' +
                ",\ncompany='" + company + '\'' +
                '}';
    }
}
