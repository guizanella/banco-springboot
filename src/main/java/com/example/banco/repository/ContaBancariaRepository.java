package com.example.banco.repository;

import com.example.banco.models.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
    ContaBancaria findById(long id);
}
