package com.aluracursos.screenmatch.logica;

import com.aluracursos.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;

public class ConversorTitulo {
    public Titulo convertirTitulo(TituloOmdb tituloOmdb)
            throws ErrorEnConversionDeDuracionException {
        return new Titulo(tituloOmdb);
    }
}
