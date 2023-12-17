package org.example.repository;

import org.example.entity.Baguette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaguetteRepo extends JpaRepository<Baguette, Long> {
}

