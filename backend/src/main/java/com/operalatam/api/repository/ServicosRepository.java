package com.operalatam.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operalatam.api.model.Servicos;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos, Long> {
    Optional<Servicos> findByNome(String nome);
}
