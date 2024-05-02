package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmatch.logica.BuscadorTitulo;
import com.aluracursos.screenmatch.logica.ConversorTitulo;
import com.aluracursos.screenmatch.logica.GestorTitulos;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalBuenasPracticas {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        BuscadorTitulo buscadorTitulo = new BuscadorTitulo();
        ConversorTitulo conversorTitulo = new ConversorTitulo();
        GestorTitulos gestorTitulos = new GestorTitulos();

        while (true) {
            System.out.println("Escriba el nombre de una pelicula: ");
            var busqueda = teclado.nextLine();

            if (busqueda.equalsIgnoreCase("salir")) {
                break;
            }

            try {
                TituloOmdb tituloOmdb = buscadorTitulo.buscarTitulo(busqueda);
                Titulo titulo = conversorTitulo.convertirTitulo(tituloOmdb);
                titulos.add(titulo);
            } catch (ErrorEnConversionDeDuracionException e) {
                System.out.println(e.getMessage());
            }
        }
        gestorTitulos.escribirTitulosEnArchivo(titulos, gson);
        System.out.println("Finalizó la ejecución del programa.");
    }
}