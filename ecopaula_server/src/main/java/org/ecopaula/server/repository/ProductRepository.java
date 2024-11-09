package org.ecopaula.server.repository;

import org.ecopaula.server.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p " +
            "JOIN p.trays t " +
            "JOIN t.cuts c " +
            "WHERE c.animal.id = :animalId")
    List<Product> findProductsByAnimalId(@Param("animalId") Integer animalId);

}
