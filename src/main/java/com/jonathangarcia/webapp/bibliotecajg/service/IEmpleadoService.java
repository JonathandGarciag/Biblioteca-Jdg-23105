package com.jonathangarcia.webapp.bibliotecajg.service;

import java.util.List;

import com.jonathangarcia.webapp.bibliotecajg.model.Empleado;

public interface IEmpleadoService {
    public List<Empleado> listarEmpleados();

    public void guardarEmpleado(Empleado empleado);

    public Empleado buscarEmpleados(Long id);

    public void eliminarEmpleado(Empleado empleado);
}
