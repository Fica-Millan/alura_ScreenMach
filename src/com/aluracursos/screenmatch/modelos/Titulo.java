package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    private String nombre;
    private int fechaLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDelasEvaluaciones;

    public Titulo(String nombre, int fechaLanzamiento) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaLanzamiento  = Integer.valueOf(miTituloOmdb.year());
        if(miTituloOmdb.runtime().contains("N/A")){
            throw new ErrorEnConversionDeDuracionException("No pude convertir la duracion," +
                    "porque contiene un N/A");
        }
        this.duracionEnMinutos = Integer.valueOf(
                miTituloOmdb.runtime().substring(0,3).replace(" ", ""));
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setFechaLanzamiento(int fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public int getTotalDelasEvaluaciones(){
        return totalDelasEvaluaciones;
    }

    public void muestraFichaTecnica(){
        System.out.println("El nombre de la pelicula es: " + nombre);
        System.out.println("Su fecha de lanzamiento es: " + fechaLanzamiento);
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
    }

    public void evalua(double nota){
        sumaDeLasEvaluaciones += nota;
        totalDelasEvaluaciones ++;
    }

    public double calculaMedia(){
        return sumaDeLasEvaluaciones / totalDelasEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "(nombre= " + nombre +
                ", fechaLanzamiento= " + fechaLanzamiento+
                ", duracion= " + duracionEnMinutos+")";
    }
}
