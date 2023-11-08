package com.api_senai.api.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_senai.api.entities.Cliente;
import com.api_senai.api.repository.ClienteRepository;

import jakarta.persistence.EntityManager;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes;
    }

    public Cliente getClienteById(Long id) {

        Cliente cliente = clienteRepository.findById(id).orElse(null);

        return cliente;
    }

    public Cliente saveCliente(Cliente novoCliente) {

        Cliente cliente = clienteRepository.save(novoCliente);
        return cliente;
    }

    public Cliente updateCliente(Long id, Cliente clienteAtualizado) {

        // Cliente clienteExistente = getClienteById(id);
        // clienteExistente.setAllAtributos(clienteAtualizado);
        // clienteExistente = new Cliente(clienteAtualizado);
        // saveCliente(clienteExistente);
        // EntityManager<Cliente> entityManager = new EntityManager();

        // if (clienteExistente != null) {
        // // Use EntityManager.merge to update the entity with new values
        // clienteExistente = entityManager.merge(clienteAtualizado);
        // }
        Optional<Cliente> cliente_novo = clienteRepository.findById(id);

        if (cliente_novo.isPresent()) {
            Cliente existente = cliente_novo.get();

            modelMapper.map(clienteAtualizado, existente);
            existente = clienteRepository.save(existente);

            return existente;
        }
        return null;
    }

    public Cliente deleteCliente(Long id) {

        clienteRepository.deleteById(id);
        Cliente clienteDeletado = getClienteById(id);

        return clienteDeletado;
    }

    public Cliente logicalDeleteCliente(Long id) {
        Cliente clienteExistente = getClienteById(id);
        clienteExistente.setAtivo(false);
        saveCliente(clienteExistente);

        return clienteExistente;
    }
}
