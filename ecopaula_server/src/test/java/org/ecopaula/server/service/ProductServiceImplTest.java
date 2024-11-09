package org.ecopaula.server.service;
import org.ecopaula.server.dto.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        // Initialize any necessary mocks or setup before tests
    }

    @Test
    public void testGetProductById() {
        ProductDTO result = productService.getProductById(1);
        assertNotNull(result);
    }

    @Test
    public void testGetAllProducts() {
        List<ProductDTO> result = productService.getAllProducts();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetProductByAnimalId() {
        List<ProductDTO> result = productService.getProductByAnimalId(1);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
