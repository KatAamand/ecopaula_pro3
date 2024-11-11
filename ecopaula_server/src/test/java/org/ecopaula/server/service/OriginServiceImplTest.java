package org.ecopaula.server.service;

import org.ecopaula.server.dto.OriginDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OriginServiceImplTest {

    @Autowired
    private OriginServiceImpl originService;

    @Test
    public void testGetOriginById_Found() {
        OriginDTO origin = originService.getOriginById(1);
        assertNotNull(origin);
    }

    @Test
    public void testGetOriginById_NotFound() {
        OriginDTO origin = originService.getOriginById(0);
        assertNull(origin);
    }

    @Test
    public void testGetAllOrigins() {
       List<OriginDTO> listOfOrigins = originService.getAllOrigins();
       assertNotNull(listOfOrigins);
    }
}
