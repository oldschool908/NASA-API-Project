package com.github.oldschool908.Project.controllers;

import com.github.oldschool908.Project.clients.HttpClientWrapper;
import com.github.oldschool908.Project.models.APOD;
import com.github.oldschool908.Project.models.MeteorFeed;
import com.github.oldschool908.Project.models.NeoResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class NASAController implements Initializable {
    private String NASAApiKey = System.getenv("NASA_API_KEY");
    private HttpClient client;
    private String baseUrl = "https://api.nasa.gov";
    private String apodPath = "/planetary/apod";
    private String feedPath = "/neo/rest/v1/feed";
    @FXML
    private Button submitButton;

    @FXML
    private TextField dateField;

    @FXML
    private TextArea explainationArea;

    @FXML
    private ImageView imageView;

    @FXML
    private Label imageTitle;

    @FXML
    void handleSubmit(ActionEvent event) {
        explainationArea.setWrapText(true);
        HashMap<String,String> params = new HashMap<>(){{
            put("date", dateField.getText());
            put("api_key",NASAApiKey);
        }};

        try {
            HttpResponse response= HttpClientWrapper.get(baseUrl + apodPath, params);
            if(response.statusCode() == 200){
                Gson gson = new GsonBuilder().create();
                APOD apod = gson.fromJson((String) response.body(), APOD.class);
                //System.out.println(apod);
                explainationArea.setText(apod.getExplanation());
                Image image = new Image(apod.getUrl());
                imageView.setImage(image);
                imageTitle.setText(apod.getTitle());

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField startDate;
    @FXML
    private TextField endDate;
    @FXML
    private TextArea Display;
    @FXML
    private ImageView imageViewEI;
    @FXML
    private Button submitButtonEI;


    @FXML
    void handleSubmitEI(ActionEvent event) {
        Display.setWrapText(true);
        HashMap<String,String> params = new HashMap<>(){{
            put("start_date", startDate.getText());
            put("end_date", endDate.getText());
            put("api_key",NASAApiKey);
        }};

        try {
            HttpResponse response= HttpClientWrapper.get(baseUrl + feedPath, params);
            if(response.statusCode() == 200){
                Gson gson = new GsonBuilder().create();
                NeoResponse neoResponse = gson.fromJson((String) response.body(), NeoResponse.class);
                //System.out.println(response1.toString());
                var nearEarthObjects = neoResponse.getNear_earth_objects();
                List<ArrayList<MeteorFeed>> meteors = nearEarthObjects.keySet().stream()
                        .map(key->nearEarthObjects.get(key))
                        .collect(Collectors.toList());
                meteors.stream().forEach(System.out::println);
//                Display.appendText(meteors.getId());
//                Display.appendText(meteors.getName());
//                Display.appendText(meteors.getAbsolut_magnitude_h());
//                Display.appendText(meteors.getEstimated_diameterFeet());
//                Display.appendText(meteors.getHazardous());
//                Display.appendText(meteors.getCloseApproachDate());
//                Display.appendText(meteors.getRelativeVelocityMPH());
//                Display.appendText(meteors.getMissDistanceMiles());
//                Image imageEI = new Image(meteors.getNasa_jpl_url());
//                imageViewEI.setImage(imageEI);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void doGet(URI uri) throws Exception {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        client = HttpClient.newHttpClient();
    }
}
