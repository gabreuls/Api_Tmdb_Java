package com.example;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ApiConsumer {
    public static void main(String[] args) throws Exception {
    
        System.out.println("Chamando API");

        String apiKey = "api_key=33a6fcbfdfa002a0055600aab72bbbbf";
        String json = new ApiClient(apiKey).getBody();
        
        System.out.println("Separando JSON");
        JsonParse jsonParse = new FilmeJsonParse(json);
        List<? extends Content> listaContent = jsonParse.parse();

        Collections.sort(listaContent, Comparator.comparing(Content::year));
        
        System.out.println("Gerando página HTML");
        PrintWriter writer = new PrintWriter("ranking.html");
        new HTMLGenerator(writer).generate(listaContent);
        writer.close();

    }

}