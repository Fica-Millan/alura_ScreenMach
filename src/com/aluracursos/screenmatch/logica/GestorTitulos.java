package com.aluracursos.screenmatch.logica;

import com.aluracursos.screenmatch.modelos.Titulo;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GestorTitulos {
    public void escribirTitulosEnArchivo(List<Titulo> titulos, Gson gson) throws IOException {
        FileWriter escritura = new FileWriter("titulo.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();
    }
}
