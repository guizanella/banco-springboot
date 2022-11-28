package com.example.banco.controllers;

import com.example.banco.interfaces.ContaBancariaService;
import com.example.banco.models.ContaBancaria;
import com.example.banco.services.ContaBancariaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "banco")
@CrossOrigin(origins = "*")
public class ContaBancariaController {
    @Autowired
    ContaBancariaService contaBancariaService;

    @GetMapping("/contas")
    public List<ContaBancaria> listaConta() {
        return contaBancariaService.listaContas();
    }

    @GetMapping("/conta/{id}")
    public ContaBancaria buscaConta(@PathVariable(value = "id") long id){
        return contaBancariaService.buscaConta(id);
    }

    @PostMapping("/conta")
    public ContaBancaria salvaConta(@RequestBody @Validated ContaBancaria contaBancaria) {
        return contaBancariaService.salvaConta(contaBancaria);
    }

    @DeleteMapping("/conta/{id}")
    public void deletaConta(@PathVariable(value = "id") long id) {
        contaBancariaService.deletaConta(id);
    }

    @PutMapping("/conta")
    public ContaBancaria alteraConta(@RequestBody @Validated ContaBancaria contaBancaria) {
        return contaBancariaService.alteraConta(contaBancaria);
    }
}
