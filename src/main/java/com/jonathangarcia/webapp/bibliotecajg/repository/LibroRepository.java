package com.jonathangarcia.webapp.bibliotecajg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonathangarcia.webapp.bibliotecajg.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
