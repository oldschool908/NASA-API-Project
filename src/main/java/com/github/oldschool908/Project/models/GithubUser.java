package com.github.ethanbrown3.githubgistsclient.models;

public class GithubUser {
    public String login;
    public Integer public_repos;
    public String bio;
    public String company;
    public String location;
    public Integer total_private_repos;

    @Override
    public String toString() {
        return "GithubUser{\n" +
                "login='" + login + '\'' +
                ",\npublic_repos=" + public_repos +
                ",\nbio='" + bio + '\'' +
                ",\ncompany='" + company + '\'' +
                ",\nlocation='" + location +'\'' +
                ",\ntotal_private_repos='" + total_private_repos +'\'' +
                '}';
    }
}
