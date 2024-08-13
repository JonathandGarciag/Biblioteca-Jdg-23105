package com.jonathangarcia.webapp.bibliotecajg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathangarcia.webapp.bibliotecajg.model.Empleado;
import com.jonathangarcia.webapp.bibliotecajg.repository.EmpleadoRepository;

@Service
public class EmpleadoService implements IEmpleadoService{
    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public Empleado buscarEmpleados(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepository.delete(empleado);
    }

    @Override
    public Boolean verificarDpiDuplicado(Empleado empleadoNuevo){
        Boolean flag = Boolean.FALSE;
        List<Empleado> empleados = listarEmpleados();

        for (Empleado e : empleados) {
            if (e.getDpi().equals(empleadoNuevo.getDpi()) && !e.getId().equals(empleadoNuevo.getId())) {
                flag = Boolean.TRUE;
            }            
        }
        return flag;
    }


}
