package com.example.banco.services;

import com.example.banco.interfaces.ClienteService;
import com.example.banco.models.Cliente;
import com.example.banco.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listaClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscaCliente(long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente salvaCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente alteraCliente(Cliente cliente) {
        if (clienteRepository.findById(cliente.getId()) != null) {
            return clienteRepository.save(cliente);
        } else {
            return null;
        }
    }

    @Override
    public void deletaCliente(long id) {
        if (clienteRepository.findById(id) != null) {
            clienteRepository.deleteById(id);
        }
    }
}
