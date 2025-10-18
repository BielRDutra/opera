package com.operalatam.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operalatam.api.model.Portao;

@Repository
public interface PortaoRepository extends JpaRepository<Portao, Long> {
    Optional<Portao> findByNome(String nome);
}