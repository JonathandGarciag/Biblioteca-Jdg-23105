package com.jonathangarcia.webapp.bibliotecajg.service;

import java.util.List;

import com.jonathangarcia.webapp.bibliotecajg.model.Categoria;

public interface ICategoriaService {

    public List<Categoria> listarCategorias();

    public void guardarCategoria(Categoria categoria);

    public Categoria buscarCategoriaPorId(Long id);

    public void eliminarCategoria(Categoria categoria);

}
