package org.ecopaula.server.repository;

import org.ecopaula.server.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a " +
            "JOIN a.cuts c " +
            "JOIN c.tray t " +
            "JOIN t.products p " +
            "WHERE p.id = :productId")
    List<Animal> findAnimalsByProductId(@Param("productId") Integer productId);
}
