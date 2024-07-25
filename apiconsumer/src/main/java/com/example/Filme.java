package com.example;

public record Filme (String title, String urlImagem, String rating, String year) implements Content {

    @Override
    public int compareTo(Content content) {

        Integer selfYear = Integer.valueOf(this.year());
        Integer otherYear = Integer.valueOf(content.year());

        return selfYear.compareTo(otherYear);
    }
}
