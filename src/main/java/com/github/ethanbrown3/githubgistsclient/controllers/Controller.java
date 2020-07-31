package com.github.ethanbrown3.githubgistsclient.controllers;

import com.github.ethanbrown3.githubgistsclient.models.GithubUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private String githubApiKey = System.getenv("GITHUB_API_KEY");
    private HttpClient client;
    private String baseUrl = "https://api.github.com";

    @FXML
    private Button submitButton;
    @FXML
    private TextArea outputArea;

    @FXML
    void handleSubmit(ActionEvent event) {
        // https://api.github.com/users/:username
        var uri = baseUrl + "/users/ethanbrown3";
        var usersUrl = URI.create(uri);
        try {
            doGet(usersUrl);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    void doGet(URI uri) throws Exception {
        // the default builder http method is GET so calling
        // .GET() on the builder is not necessary
        var request = HttpRequest.newBuilder(uri)
                .header("Accept", "application/json")
                .build();
        // send() is a blocking synchronous call
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (response.statusCode() == 200) {
            GithubUser user = gson.fromJson(response.body(), GithubUser.class);
            outputArea.setText(response.toString() + "\n" + user.toString());
        } else {
            outputArea.setText(response.toString());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        client = HttpClient.newHttpClient();
    }
}
