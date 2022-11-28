package com.example.banco.controllers;

import com.example.banco.interfaces.ClienteService;
import com.example.banco.models.Cliente;
import com.example.banco.services.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "banco")
@CrossOrigin(origins = "*")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> listaClientes() {
        return clienteService.listaClientes();
    }

    @GetMapping("/cliente/{id}")
    public Cliente buscaCliente(@PathVariable(value = "id") long id){
        return clienteService.buscaCliente(id);
    }

    @PostMapping("/cliente")
    public Cliente salvaCliente(@RequestBody @Validated Cliente cliente) {
        return clienteService.salvaCliente(cliente);
    }

    @DeleteMapping("/cliente/{id}")
    public void deletaCliente(@PathVariable(value = "id") long id) {
        clienteService.deletaCliente(id);
    }

    @PutMapping("/cliente")
    public Cliente alteraCliente(@RequestBody @Validated Cliente cliente) {
        return clienteService.alteraCliente(cliente);
    }
}
