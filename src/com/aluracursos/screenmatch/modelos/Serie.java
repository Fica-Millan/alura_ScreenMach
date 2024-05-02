package com.aluracursos.screenmatch.modelos;

public class Serie extends Titulo{
    int temporada;
    int episodiosPorTemporada;
    int minutosPorEpisodio;

    public Serie(String nombre, int fechaLanzamiento) {
        super(nombre, fechaLanzamiento);
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    @Override
    public int getDuracionEnMinutos() {
        return temporada * episodiosPorTemporada * minutosPorEpisodio;
    }

    @Override
    public String toString() {
        return "Serie: "+this.getNombre()+" ("+this.getFechaLanzamiento()+")";
    }
}
