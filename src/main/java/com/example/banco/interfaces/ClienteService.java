package com.example.banco.interfaces;

import com.example.banco.models.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> listaClientes();
    Cliente buscaCliente(long id);
    Cliente salvaCliente(Cliente cliente);
    Cliente alteraCliente(Cliente cliente);
    void deletaCliente(long id);
}
