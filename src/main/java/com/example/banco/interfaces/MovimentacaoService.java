package com.example.banco.interfaces;

import com.example.banco.models.Movimentacao;

import java.util.List;

public interface MovimentacaoService {
    List<Movimentacao> listaMovimentacoes();
    Movimentacao buscaMovimentacao(long id);
    Movimentacao salvaMovimentacao(Movimentacao movimentacao);
    Movimentacao alteraMovimentacao(Movimentacao movimentacao);
    void deletaMovimetacao(long id);
}
