package com.jonathangarcia.webapp.bibliotecajg.service;

import java.util.List;

import com.jonathangarcia.webapp.bibliotecajg.model.Cliente;

public interface IClienteService {

    public List<Cliente> listarClientes();

    public void guardarCliente(Cliente cliente);

    public Cliente buscarClientePorId(Long DPI);

    public void eliminarCliente(Cliente cliente);
}
