package com.github.ethanbrown3.githubgistsclient.controllers;

import com.github.ethanbrown3.githubgistsclient.models.GithubUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

public class PublicUserController implements Initializable {
    private String githubApiKey = System.getenv("GITHUB_API_KEY");
    private HttpClient client;
    private String baseUrl = "https://api.github.com";

    @FXML
    private Button submitButton;
    @FXML
    private TextField userField;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label bioLabel;
    @FXML
    private Label companyLabel;
    @FXML
    private Label repoCountLabel;
    @FXML
    private Label locationLabel;

    @FXML
    void handleSubmit(ActionEvent event) {
        // https://api.github.com/users/:username
        var uri = baseUrl + "/users/" + userField.getText();
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
        int statusCode = response.statusCode();
        if (statusCode == 200) {
            GithubUser user = gson.fromJson(response.body(), GithubUser.class);
            System.out.println(response.toString() + "\n" + user.toString());
            displayUserData(user);
        } else if (statusCode == 404) {
            clearUserData();
            usernameLabel.setText("User not found");
            System.out.println("User not found");
        }
    }

    void displayUserData(GithubUser user) {
        usernameLabel.setText(user.getLogin());
        bioLabel.setText(user.getBio());
        companyLabel.setText(user.getCompany());
        locationLabel.setText(user.getLocation());
        repoCountLabel.setText(user.getPublicRepos().toString());
    }

    void clearUserData() {
        usernameLabel.setText("");
        bioLabel.setText("");
        companyLabel.setText("");
        locationLabel.setText("");
        repoCountLabel.setText("");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        client = HttpClient.newHttpClient();
    }
}
