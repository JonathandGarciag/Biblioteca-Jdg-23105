package com.jonathangarcia.webapp.bibliotecajg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jonathangarcia.webapp.bibliotecajg.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    
}
