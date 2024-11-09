package org.ecopaula.server.service;


import org.ecopaula.server.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO getProductById(int id);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getProductByAnimalId(int animalId);
}