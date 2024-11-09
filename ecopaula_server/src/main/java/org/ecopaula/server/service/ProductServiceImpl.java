package org.ecopaula.server.service;

import org.ecopaula.server.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductDTO getProductById(int id) {
        return null;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public List<ProductDTO> getProductByAnimalId(int animalId) {
        return List.of();
    }
}
