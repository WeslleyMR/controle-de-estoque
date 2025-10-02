package com.consumoApi.repository;

import com.consumoApi.entities.Movements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementsRepository extends JpaRepository<Movements, Integer> {
}
