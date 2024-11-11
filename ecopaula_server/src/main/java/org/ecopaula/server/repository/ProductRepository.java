package org.ecopaula.server.repository;

import org.ecopaula.server.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p " +
            "JOIN p.trays t " +
            "JOIN t.cuts c " +
            "WHERE c.animal.id = :animalId")
    List<Product> findProductsByAnimalId(@Param("animalId") Integer animalId);

}
