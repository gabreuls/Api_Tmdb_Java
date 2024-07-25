package com.example;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FilmeJsonParse implements JsonParse{

    private String json;

    public FilmeJsonParse(String json) {
        this.json = json;
    }

    @Override
    public List<Filme> parse() {
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonArray results = jsonObject.getAsJsonArray("results");

        List<Filme> filmes = new ArrayList<>();
        for (JsonElement element : results) {
            JsonObject filmeObject = element.getAsJsonObject();

            String title = filmeObject.get("title").getAsString();
            String posterPath = filmeObject.get("poster_path").getAsString();
            String imageUrl = "https://image.tmdb.org/t/p/w500" + posterPath;
            String releaseDate = filmeObject.get("release_date").getAsString();
            String year = releaseDate.length() >= 4 ? releaseDate.substring(0, 4) : "N/A";
            String rating = filmeObject.get("vote_average").getAsString();

            filmes.add(new Filme(title, imageUrl, rating, year));
        }

        return filmes;
    }
}
