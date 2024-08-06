package com.jonathangarcia.webapp.bibliotecajg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jonathangarcia.webapp.bibliotecajg.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
