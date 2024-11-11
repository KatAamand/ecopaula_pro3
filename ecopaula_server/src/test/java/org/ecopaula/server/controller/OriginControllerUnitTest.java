package org.ecopaula.server.controller;

import org.ecopaula.server.dto.OriginDTO;
import org.ecopaula.server.service.OriginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OriginController.class)
public class OriginControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OriginService originService;

    @Test
    public void getAllOriginsTest() throws Exception {
        // arrange
        OriginDTO origin1 = new OriginDTO(1, "Farm_1");
        OriginDTO origin2 = new OriginDTO(2, "Farm_2");
        List<OriginDTO> origins = List.of(origin1, origin2);

        when(originService.getAllOrigins()).thenReturn(origins);

        // act and assert
        mockMvc.perform(get("/origins")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(origins.size()))
                .andExpect(jsonPath("$[0].id").value(origin1.getId()))
                .andExpect(jsonPath("$[0].name_of_farm").value(origin1.getName_of_farm()))
                .andExpect(jsonPath("$[1].id").value(origin2.getId()))
                .andExpect(jsonPath("$[1].name_of_farm").value(origin2.getName_of_farm()));
    }
}
