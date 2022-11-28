package com.example.banco.services;

import com.example.banco.interfaces.ContaBancariaService;
import com.example.banco.models.Agencia;
import com.example.banco.models.Cliente;
import com.example.banco.models.ContaBancaria;
import com.example.banco.repository.AgenciaRepository;
import com.example.banco.repository.ClienteRepository;
import com.example.banco.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaBancariaServiceImpl implements ContaBancariaService {
    @Autowired
    ContaBancariaRepository contaBancariaRepository;
    @Autowired
    AgenciaRepository agenciaRepository;
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<ContaBancaria> listaContas() {
        return contaBancariaRepository.findAll();
    }

    @Override
    public ContaBancaria buscaConta(long id) {
        return contaBancariaRepository.findById(id);
    }

    @Override
    public ContaBancaria salvaConta(ContaBancaria contaBancaria) {
        if (!validaConta(contaBancaria)) return null;
        contaBancaria.setSaldo(0.0);
        return contaBancariaRepository.save(contaBancaria);
    }

    @Override
    public ContaBancaria alteraConta(ContaBancaria contaBancaria) {
        if (contaBancariaRepository.findById(contaBancaria.getNumero()) != null) {
            if (!validaConta(contaBancaria)) return null;
            contaBancaria.setSaldo(contaBancariaRepository.findById(contaBancaria.getNumero()).getSaldo());
            return contaBancariaRepository.save(contaBancaria);
        } else return null;
    }

    @Override
    public void deletaConta(long id) {
        if (contaBancariaRepository.findById(id) != null) {
            contaBancariaRepository.deleteById(id);
        }
    }

    private boolean validaConta(ContaBancaria conta) {
        Agencia agencia = agenciaRepository.findById(conta.getAgencia().getNumero());
        Cliente titular = clienteRepository.findById(conta.getTitular().getId());
        if (agencia == null || titular == null) return false;
        return true;
    }
}
