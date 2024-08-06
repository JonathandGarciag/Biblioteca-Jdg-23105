package com.jonathangarcia.webapp.bibliotecajg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathangarcia.webapp.bibliotecajg.model.Cliente;
import com.jonathangarcia.webapp.bibliotecajg.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
       return clienteRepository.findAll();
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente buscarClientePorDpi(Long DPI) {
       return clienteRepository.findById(DPI).orElse(null);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
