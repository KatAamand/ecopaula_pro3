package org.ecopaula.server.service;

import dto.ProductDTO;
import org.ecopaula.server.repository.ProductRepository;
import org.ecopaula.server.util.converters.ProductConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public ProductServiceImpl(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    @Override
    public ProductDTO getProductById(int id) {
        return productRepository.findById(id).map(productConverter::toDTO).orElse(null);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(productConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductByAnimalId(int animalId) {
        return productRepository.findProductsByAnimalId(animalId).stream().map(productConverter::toDTO).collect(Collectors.toList());
    }
}
