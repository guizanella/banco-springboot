package com.example.banco.repository;

import com.example.banco.models.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
    Agencia findById(long id);
}
