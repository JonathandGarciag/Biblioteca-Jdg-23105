package com.jonathangarcia.webapp.bibliotecajg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathangarcia.webapp.bibliotecajg.model.Empleado;
import com.jonathangarcia.webapp.bibliotecajg.service.EmpleadoService;

@Controller
@RestController
@RequestMapping("empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/")
    public ResponseEntity<List<Empleado>> listarEmpleado(){
        try {
            return ResponseEntity.ok(empleadoService.listarEmpleados());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarEmpleados(@PathVariable Long id){
        try {
            Empleado empleado = empleadoService.buscarEmpleados(id);
            return ResponseEntity.ok(empleado);    
        } catch (Exception e) {
            return ResponseEntity.ok().body(null);    
        }
    }

    @PutMapping("/")
    public ResponseEntity<Map<String, Boolean>> agregarEmpelado(@RequestBody Empleado empleado){
        Map<String, Boolean> response = new HashMap<>();
        try {
            empleadoService.guardarEmpleado(empleado);
            response.put("Se agrego el empleado con exito", Boolean.TRUE);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("Se agrego el empleado con exito", Boolean.FALSE);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <Map<String, Boolean>> editarEmpleado(@PathVariable Long id, @RequestBody Empleado empleadoNuevo){
        Map<String, Boolean> response = new HashMap<>();
        try {
            Empleado empleado = empleadoService.buscarEmpleados(id);
            empleado.setNombre(empleadoNuevo.getNombre());
            empleado.setApellido(empleadoNuevo.getApellido());
            empleado.setTelefono(empleadoNuevo.getTelefono());
            empleado.setDpi(empleadoNuevo.getDpi());
            empleado.setDireccion(empleadoNuevo.getDireccion());
            response.put("Se edito los datos con exito", Boolean.TRUE);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("Se edito los datos con exito", Boolean.FALSE);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Map<String, Boolean>> eliminarEmpleado(@PathVariable Long id){
        Map<String, Boolean> response = new HashMap<>();
        try {
            Empleado empleado = empleadoService.buscarEmpleados(id);
            empleadoService.eliminarEmpleado(empleado);
            response.put("Se elimino el empleado con exito", Boolean.TRUE);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("Se elimino el empleado con exito", Boolean.TRUE);
            return ResponseEntity.badRequest().body(response);
        }
    }
}