package com.example.banco.controllers;

import com.example.banco.interfaces.AgenciaService;
import com.example.banco.models.Agencia;
import com.example.banco.services.AgenciaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "banco")
@CrossOrigin(origins = "*")
public class AgenciaController {
    @Autowired
    AgenciaService agenciaService;

    @GetMapping("/agencias")
    public List<Agencia> listaAgencia() {
        return agenciaService.listaAgencias();
    }

    @GetMapping("/agencia/{id}")
    public Agencia buscaAgencia(@PathVariable(value = "id") long id){
        return agenciaService.buscaAgencia(id);
    }

    @PostMapping("/agencia")
    public Agencia salvaAgencia(@RequestBody @Validated Agencia agencia) {
        return agenciaService.salvaAgencia(agencia);
    }

    @DeleteMapping("/agencia/{id}")
    public void deletaAgencia(@PathVariable(value = "id") long id) {
        agenciaService.deletaAgencia(id);
    }

    @PutMapping("/agencia")
    public Agencia alteraAgencia(@RequestBody @Validated Agencia agencia) {
        return agenciaService.alteraAgencia(agencia);
    }
}
