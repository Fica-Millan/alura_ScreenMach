package com.aluracursos.screenmatch.logica;

import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscadorTitulo {
    public TituloOmdb buscarTitulo(String busqueda)
            throws IOException, InterruptedException {
        String direccion = "https://www.omdbapi.com/?t=" +
                busqueda.replace(" ", "+") +
                "&apikey=f98b8d9a";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        Gson gson = new Gson();
        return gson.fromJson(json, TituloOmdb.class);
    }
}
