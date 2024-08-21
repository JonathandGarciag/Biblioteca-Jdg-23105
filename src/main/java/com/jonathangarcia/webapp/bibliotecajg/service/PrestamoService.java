package com.jonathangarcia.webapp.bibliotecajg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jonathangarcia.webapp.bibliotecajg.model.Prestamo;
import com.jonathangarcia.webapp.bibliotecajg.repository.PrestamoRepository;

public class PrestamoService implements IPrestamoService{
    @Autowired
    PrestamoRepository prestamoRepository;
 
    @Override
    public List<Prestamo> listarPrestamo() {
        return prestamoRepository.findAll();
    }
 
    @Override
    public Prestamo buscarPrestamoPorId(Long id) {
       return prestamoRepository.findById(id).orElse(null);
    }
 
    @Override
    public Prestamo guardarPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }
 
    @Override
    public void eliminarPrestamo(Prestamo prestamo) {
        prestamoRepository.delete(prestamo);
    }
}
