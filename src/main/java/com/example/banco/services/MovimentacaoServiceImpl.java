package com.example.banco.services;

import com.example.banco.interfaces.MovimentacaoService;
import com.example.banco.models.ContaBancaria;
import com.example.banco.models.Movimentacao;
import com.example.banco.repository.ContaBancariaRepository;
import com.example.banco.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {
    @Autowired
    MovimentacaoRepository movimentacaoRepository;
    @Autowired
    ContaBancariaRepository contaBancariaRepository;

    @Override
    public List<Movimentacao> listaMovimentacoes() {
        return movimentacaoRepository.findAll();
    }

    @Override
    public Movimentacao buscaMovimentacao(long id) {
        return movimentacaoRepository.findById(id);
    }

    @Override
    public Movimentacao salvaMovimentacao(Movimentacao movimentacao) {
        if (!realizaMovimentacoes(movimentacao)) return null;

        movimentacao.setDataMovimentacao(new Date());
        return movimentacaoRepository.save(movimentacao);
    }

    @Override
    public Movimentacao alteraMovimentacao(Movimentacao movimentacao) {
        if (movimentacaoRepository.findById(movimentacao.getId()) != null) {
            return movimentacaoRepository.save(movimentacao);
        } else return null;
    }

    @Override
    public void deletaMovimetacao(long id) {
        if (movimentacaoRepository.findById(id) != null) {
            movimentacaoRepository.deleteById(id);
        }
    }

    private boolean realizaMovimentacoes(Movimentacao movimentacao) {
        ContaBancaria destino = null;
        ContaBancaria origem = null;

        if (movimentacao.getContaDestino() != null) {
            destino = contaBancariaRepository.findById(movimentacao.getContaDestino().getNumero());
        }
        if (movimentacao.getContaOrigem() != null) {
            origem = contaBancariaRepository.findById(movimentacao.getContaOrigem().getNumero());
        }

        if (!validaValores(movimentacao, origem)) return false;

        if (movimentacao.getTipoMovimentacao().equalsIgnoreCase("deposito")) {
            if (destino != null) {
                destino.deposito(movimentacao.getValor());
                contaBancariaRepository.save(destino);
            } else return false;
        } else if (movimentacao.getTipoMovimentacao().equalsIgnoreCase("saque")) {
            origem.saque(movimentacao.getValor());
            contaBancariaRepository.save(origem);
        } else if (movimentacao.getTipoMovimentacao().equalsIgnoreCase("transferencia")) {
            if (destino != null) {
                origem.saque(movimentacao.getValor());
                destino.deposito(movimentacao.getValor());
                contaBancariaRepository.save(origem);
                contaBancariaRepository.save(destino);
            } else return false;
        } else return false;

        return true;
    }

    private boolean validaValores(Movimentacao movimentacao, ContaBancaria origem) {
        if (movimentacao.getValor() < 0) return false;
        if (!movimentacao.getTipoMovimentacao().equalsIgnoreCase("deposito")) {
            if (origem == null) return false;
            if (origem.getSaldo() < movimentacao.getValor()) return false;
        }
        return true;
    }
}