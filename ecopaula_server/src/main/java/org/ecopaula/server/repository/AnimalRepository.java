package org.ecopaula.ecopaula_server.repository;

import org.ecopaula.ecopaula_server.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
