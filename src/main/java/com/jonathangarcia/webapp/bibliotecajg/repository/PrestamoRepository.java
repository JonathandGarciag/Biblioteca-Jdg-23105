package com.jonathangarcia.webapp.bibliotecajg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonathangarcia.webapp.bibliotecajg.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long>{

}
