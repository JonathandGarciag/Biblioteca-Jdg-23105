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

import com.jonathangarcia.webapp.bibliotecajg.model.Empleado;
import com.jonathangarcia.webapp.bibliotecajg.service.EmpleadoService;

@Controller
@RestController
@RequestMapping("empleado")
@CrossOrigin(value = "http://127.0.0.1:5500")
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

    @GetMapping("/id={id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorId(@PathVariable Long id){
        try {
            Empleado empleado = empleadoService.buscarEmpleadoPorId(id);
            return ResponseEntity.ok(empleado);    
        } catch (Exception e) {
            return ResponseEntity.ok().body(null);    
        }
    }

    @PostMapping("/empleado")
    public ResponseEntity<Map<String, String>> agregarEmpelado(@RequestBody Empleado empleado){
        Map<String, String> response = new HashMap<>();
        try {
            if (!empleadoService.verificarDpiDuplicado(empleado)) {
                empleadoService.guardarEmpleado(empleado);
                response.put("Se agrego el empleado con exito", "Empleado con exito");
                return ResponseEntity.ok(response);
            }else{
                response.put("message", "Error");
                response.put("err", "El dpi se encuentra duplicado");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("Se agrego el empleado con exito", "Hubo un error al crear el empleado");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <Map<String, String>> editarEmpleado(@PathVariable Long id, @RequestBody Empleado empleadoNuevo){
        Map<String, String> response = new HashMap<>();
        try {
            Empleado empleado = empleadoService.buscarEmpleadoPorId(id);
            empleado.setNombre(empleadoNuevo.getNombre());
            empleado.setApellido(empleadoNuevo.getApellido());
            empleado.setTelefono(empleadoNuevo.getTelefono());
            empleado.setDpi(empleadoNuevo.getDpi());
            empleado.setDireccion(empleadoNuevo.getDireccion());
            if (!empleadoService.verificarDpiDuplicado(empleadoNuevo)) {
                empleadoService.guardarEmpleado(empleado);
                response.put("message", "Se edito los datos con exito");
                return ResponseEntity.ok(response);
            } else{
                response.put("message", "Error");
                response.put("err", "El dpi se encuentra duplicado");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("Se edito los datos con exito", "Se edito los datos con exito");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Map<String, Boolean>> eliminarEmpleado(@PathVariable Long id){
        Map<String, Boolean> response = new HashMap<>();
        try {
            Empleado empleado = empleadoService.buscarEmpleadoPorId(id);
            empleadoService.eliminarEmpleado(empleado);
            response.put("Se elimino el empleado con exito", Boolean.TRUE);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("Se elimino el empleado con exito", Boolean.TRUE);
            return ResponseEntity.badRequest().body(response);
        }
    }
}
