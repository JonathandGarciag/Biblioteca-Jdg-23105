package com.jonathangarcia.webapp.bibliotecajg.service;

import java.util.List;

import com.jonathangarcia.webapp.bibliotecajg.model.Prestamo;

public interface IPrestamoService {

    public List<Prestamo> listarPrestamo();
 
    public Prestamo buscarPrestamoPorId(Long id);
 
    public Prestamo guardPrestamo(Prestamo prestamo);
 
    public void eliminarPrestamo(Prestamo prestamo);

}
