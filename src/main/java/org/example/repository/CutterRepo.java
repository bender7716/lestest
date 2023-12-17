package org.example.repository;

import org.example.entity.Cutter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CutterRepo extends JpaRepository<Cutter, Long> {
}

