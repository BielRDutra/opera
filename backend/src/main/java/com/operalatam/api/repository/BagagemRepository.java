package com.operalatam.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operalatam.api.model.Bagagem;

@Repository
public interface BagagemRepository extends JpaRepository<Bagagem, Long> {
    Optional<Bagagem> findByEtiqueta(Long etiqueta);
}
