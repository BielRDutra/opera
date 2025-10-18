package com.operalatam.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operalatam.api.model.Ramal;

@Repository
public interface RamalRepository extends JpaRepository<Ramal, Long> {
    Optional<Ramal> findByNome(String nome);
}
