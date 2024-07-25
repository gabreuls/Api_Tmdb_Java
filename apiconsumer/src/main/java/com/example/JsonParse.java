package com.example;

import java.util.List;

public interface JsonParse {
    
    // Esse método retorna qualquer Lista de um objeto que seja derivado de Content
    List<? extends Content> parse();
}
