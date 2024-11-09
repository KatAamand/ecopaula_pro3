package org.ecopaula.server.controller;

import org.ecopaula.server.dto.OriginDTO;
import org.ecopaula.server.service.OriginService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class OriginControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OriginService originService;

    private OriginDTO sampleOrigin;

    @BeforeEach
    public void setup() {
        sampleOrigin = new OriginDTO();
        sampleOrigin.setId(1);
        sampleOrigin.setName_of_farm("Farm A");
    }

    @Test
    public void testGetAllOrigins() throws Exception {
        when(originService.getAllOrigins()).thenReturn(List.of(sampleOrigin));

        mockMvc.perform(get("/origins")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(sampleOrigin.getId()))
                .andExpect(jsonPath("$[0].name_of_farm").value(sampleOrigin.getName_of_farm()));
    }
}
