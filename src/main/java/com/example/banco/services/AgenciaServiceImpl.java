package com.example.banco.services;

import com.example.banco.interfaces.AgenciaService;
import com.example.banco.models.Agencia;
import com.example.banco.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenciaServiceImpl implements AgenciaService {
    @Autowired
    AgenciaRepository agenciaRepository;

    @Override
    public List<Agencia> listaAgencias() {
        return agenciaRepository.findAll();
    }

    @Override
    public Agencia buscaAgencia(long id) {
        return agenciaRepository.findById(id);
    }

    @Override
    public Agencia salvaAgencia(Agencia agencia) {
        return agenciaRepository.save(agencia);
    }

    @Override
    public Agencia alteraAgencia(Agencia agencia) {
        if (agenciaRepository.findById(agencia.getNumero()) != null) {
            return agenciaRepository.save(agencia);
        } else {
            return null;
        }
    }

    @Override
    public void deletaAgencia(long id) {
        if (agenciaRepository.findById(id) != null) {
            agenciaRepository.deleteById(id);
        }
    }
}
