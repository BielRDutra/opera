package com.operalatam.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operalatam.api.model.Briefing;

@Repository
public interface BriefingRepository extends JpaRepository<Briefing, Long> {
    Optional<Briefing> findByNome(String nome);
}