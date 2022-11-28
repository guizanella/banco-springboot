package com.example.banco.repository;

import com.example.banco.models.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    Movimentacao findById(long id);
}
