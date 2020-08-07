package com.github.oldschool908.Project.clients;

import com.github.oldschool908.Project.models.APOD;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class HttpClientWrapper {

    public static HttpResponse<String> get(String uri, HashMap<String,String> params) throws IOException, InterruptedException{

        var paramsString = params.keySet().stream()
                .map(key->key+"="+params.get(key))
                .collect(Collectors.joining("&"));
        var requestURI = URI.create(uri + "?" + paramsString);
        var request = HttpRequest.newBuilder(requestURI)
                .GET()
                .header("Accept","application/json")
                .build();
        var client = HttpClient.newHttpClient();
        return client.send(request,HttpResponse.BodyHandlers.ofString());
    }
}
