package com.Backend.repositories;

import com.Backend.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}
