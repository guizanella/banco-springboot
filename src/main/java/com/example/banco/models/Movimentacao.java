package com.example.banco.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Movimentacoes")
public class Movimentacao {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String tipoMovimentacao;
    @ManyToOne
    private ContaBancaria contaOrigem;
    @ManyToOne
    private ContaBancaria contaDestino;
    @NotNull
    private double valor;
    @NotNull
    private Date dataMovimentacao;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }
    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public ContaBancaria getContaOrigem() {
        return contaOrigem;
    }
    public void setContaOrigem(ContaBancaria contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public ContaBancaria getContaDestino() {
        return contaDestino;
    }
    public void setContaDestino(ContaBancaria contaDestino) {
        this.contaDestino = contaDestino;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }
    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }
}
