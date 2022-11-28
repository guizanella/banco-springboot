package com.example.banco.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class ContaBancaria {
    @Id
    @GeneratedValue
    private long numero;
    @NotNull
    private double saldo;
    @NotNull
    @OneToOne
    private Cliente titular;
    @NotNull
    @ManyToOne
    private Agencia agencia;

    public long getNumero() {
        return numero;
    }
    public void setNumero(long numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Agencia getAgencia() {
        return agencia;
    }
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public void deposito(double valor) {
        this.saldo += valor;
    }
    public void saque(double valor) {
        this.saldo -= valor;
    }
}
