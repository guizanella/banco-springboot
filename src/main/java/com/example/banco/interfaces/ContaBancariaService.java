package com.example.banco.interfaces;

import com.example.banco.models.ContaBancaria;

import java.util.List;

public interface ContaBancariaService {
    List<ContaBancaria> listaContas();
    ContaBancaria buscaConta(long id);
    ContaBancaria salvaConta(ContaBancaria contaBancaria);
    ContaBancaria alteraConta(ContaBancaria contaBancaria);
    void deletaConta(long id);
}
