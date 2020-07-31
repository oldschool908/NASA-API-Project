module GithubGistsClient {
        requires javafx.fxml;
        requires javafx.controls;
        requires javafx.graphics;
        requires java.net.http;
        requires com.google.gson;

        opens com.github.ethanbrown3.githubgistsclient.controllers;
        exports com.github.ethanbrown3.githubgistsclient;
        opens com.github.ethanbrown3.githubgistsclient to javafx.graphics;
}