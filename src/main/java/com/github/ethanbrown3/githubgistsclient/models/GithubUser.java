package com.github.ethanbrown3.githubgistsclient.models;

public class GithubUser {
    private String login;
    private int public_repos;
    private String bio;
    private String company;

    public GithubUser(String login, int publicRepos, String bio, String company) {
        this.login = login;
        this.public_repos = publicRepos;
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

    @Override
    public String toString() {
        return "GithubUser{\n" +
                "login='" + login + '\'' +
                ",\npublic_repos=" + public_repos +
                ",\nbio='" + bio + '\'' +
                ",\ncompany='" + company + '\'' +
                '}';
    }
}
