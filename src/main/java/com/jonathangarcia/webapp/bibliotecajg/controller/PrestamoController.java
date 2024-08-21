package com.jonathangarcia.webapp.bibliotecajg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathangarcia.webapp.bibliotecajg.model.Prestamo;
import com.jonathangarcia.webapp.bibliotecajg.service.PrestamoService;

@Controller
@RestController
@RequestMapping("prestamo")
@CrossOrigin(value = "http://127.0.0.1:5500")
public class PrestamoController {

    @Autowired
    PrestamoService prestamoService;

    @GetMapping("/")
    public ResponseEntity<?> listarPrestamos() {
        Map<String, String> response = new HashMap<>();
        try {
            return ResponseEntity.ok(prestamoService.listarPrestamo());
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "No se encontró una lista de libros.");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPrestamo(@PathVariable Long id) {
        Map<String, Boolean> response = new HashMap<>();
        try {
            Prestamo prestamo = prestamoService.buscarPrestamoPorId(id);
            return ResponseEntity.ok(prestamo);
        } catch (Exception e) {
            response.put("El prestamo no se pudo encontrar", Boolean.FALSE);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, String>> agregarPrestamo(@RequestBody Prestamo prestamo) {
        Map<String, String> response = new HashMap<>();
        try {
            prestamoService.guardarPrestamo(prestamo);
            response.put("message", "Prestamo creado con éxito");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Hubo un error al crear el prestamo");
            return ResponseEntity.badRequest().body(response);
        }
    }
 
    @PutMapping("/{id}")
    public ResponseEntity <Map<String, Boolean>> editarPrestamo(@PathVariable Long id,  Prestamo prestamoNuevo) {
        Map<String, Boolean> response = new HashMap<>();
        try {
            Prestamo prestamo = prestamoService.buscarPrestamoPorId(id);
            prestamo.setLibro(prestamoNuevo.getLibro());
            prestamo.setCliente(prestamoNuevo.getCliente());
            prestamo.setEmpleado(prestamoNuevo.getEmpleado());
            prestamo.setFechaPrestamo(prestamoNuevo.getFechaPrestamo());
            prestamo.setFechaDevolucion(prestamoNuevo.getFechaDevolucion());
            prestamo.setVigencia(prestamoNuevo.getVigencia());
            response.put("Se editaron los datos del Prestamo con exito", Boolean.TRUE);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("No se lograron editar los datos con exito", Boolean.FALSE);
            return ResponseEntity.badRequest().body(response);
        }
    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity <Map<String, Boolean>> eliminarPrestamo(@PathVariable Long id){
        Map<String, Boolean> response = new HashMap<>();
        try {
            Prestamo prestamo = prestamoService.buscarPrestamoPorId(id);
            prestamoService.eliminarPrestamo(prestamo);
            response.put("Se ha eliminado el Prestamo con exito", Boolean.TRUE);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("No se elimino el Prestamo", Boolean.FALSE);
            return ResponseEntity.badRequest().body(response);
        }
    }

}
