package org.ecopaula.server.service;
import org.ecopaula.server.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void testGetProductById() {
        ProductDTO result = productService.getProductById(1);
        assertNotNull(result);
    }

    @Test
    public void testGetAllProducts() {
        List<ProductDTO> result = productService.getAllProducts();
        assertNotNull(result);
        assertTrue(!result.isEmpty());
    }

    @Test
    public void testGetProductByAnimalId() {
        List<ProductDTO> result = productService.getProductByAnimalId(1);
        assertNotNull(result);
        assertTrue(!result.isEmpty());
    }
}
