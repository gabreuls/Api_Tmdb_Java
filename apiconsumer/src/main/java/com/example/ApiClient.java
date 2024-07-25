package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient implements TmdbClient{

    private String apiKey;

    public ApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getBody() {

        try {
            URI enderecoApi = URI.create("https://api.themoviedb.org/3/trending/movie/week?" + this.apiKey);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(enderecoApi).build();

            HttpResponse<String> resposta = client.send(request, HttpResponse.BodyHandlers.ofString());

            return resposta.body();

        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
