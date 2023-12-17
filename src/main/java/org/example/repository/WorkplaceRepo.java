package org.example.repository;

import org.example.entity.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkplaceRepo extends JpaRepository<Workplace, Long> {
}

