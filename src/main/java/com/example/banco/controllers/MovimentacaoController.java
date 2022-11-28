package com.example.banco.controllers;

import com.example.banco.interfaces.MovimentacaoService;
import com.example.banco.models.Movimentacao;
import com.example.banco.services.MovimentacaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "banco")
@CrossOrigin(origins = "*")
public class MovimentacaoController {
    @Autowired
    MovimentacaoService movimentacaoService;

    @GetMapping("/movimentacoes")
    public List<Movimentacao> listaMovimentacoes() {
        return movimentacaoService.listaMovimentacoes();
    }

    @GetMapping("/movimentacao/{id}")
    public Movimentacao buscaMovimentacao(@PathVariable(value = "id") long id){
        return movimentacaoService.buscaMovimentacao(id);
    }

    @PostMapping("/movimentacao")
    public Movimentacao salvaMovimentacao(@RequestBody @Validated Movimentacao movimentacao) {
        return movimentacaoService.salvaMovimentacao(movimentacao);
    }

    @DeleteMapping("/movimentacao/{id}")
    public void deletaMovimentacao(@PathVariable(value = "id") long id) {
        movimentacaoService.deletaMovimetacao(id);
    }

    @PutMapping("/movimentacao")
    public Movimentacao alteraMovimentacao(@RequestBody @Validated Movimentacao movimentacao) {
        return movimentacaoService.alteraMovimentacao(movimentacao);
    }
}
