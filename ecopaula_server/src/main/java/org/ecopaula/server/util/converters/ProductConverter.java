package org.ecopaula.server.util.converters;

import dto.ProductDTO;
import entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setDescription(productDTO.getDescription());

        return product;
    }

    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setDescription(product.getDescription());
        return productDTO;
    }
}
