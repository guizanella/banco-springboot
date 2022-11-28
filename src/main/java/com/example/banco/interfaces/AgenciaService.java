package com.example.banco.interfaces;

import com.example.banco.models.Agencia;

import java.util.List;

public interface AgenciaService {
    List<Agencia> listaAgencias();
    Agencia buscaAgencia(long id);
    Agencia salvaAgencia(Agencia agencia);
    void deletaAgencia(long id);
    Agencia alteraAgencia(Agencia agencia);
}
