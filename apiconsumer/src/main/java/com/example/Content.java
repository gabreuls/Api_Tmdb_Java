package com.example;

public interface Content extends Comparable<Content> {
    String title();
    String urlImagem();
    String rating();
    String year();
}
