package com.github.ethanbrown3.githubgistsclient.clients;

import com.github.ethanbrown3.githubgistsclient.models.GithubUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;

public class HttpClientWrapper {
    private HttpClient client;

    public HttpClientWrapper() {
        this.client = HttpClient.newHttpClient();
    }

    public HttpResponse<String> get(URI uri, ArrayList<String> headers) throws Exception {
        // the default builder http method is GET so calling
        var request = HttpRequest.newBuilder(uri)
                .GET()
                .headers(headers.toArray(new String[0]))
                .build();
        // send() is a blocking synchronous call
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
