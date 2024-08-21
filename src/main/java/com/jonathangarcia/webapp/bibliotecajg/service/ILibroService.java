package com.jonathangarcia.webapp.bibliotecajg.service;

import java.util.List;

import com.jonathangarcia.webapp.bibliotecajg.model.Libro;

public interface ILibroService {
    public List<Libro> listarLibros();

    public Libro guardarLibro(Libro libro);

    public Libro buscaLibroporId(Long id);

    public void eliminarLibro(Libro libro);
}
