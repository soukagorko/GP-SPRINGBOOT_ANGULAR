package com.Backend.repositories;

import com.Backend.entities.Demande;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Transactional
public interface DemandeRepository extends JpaRepository<Demande, Long> {
}
