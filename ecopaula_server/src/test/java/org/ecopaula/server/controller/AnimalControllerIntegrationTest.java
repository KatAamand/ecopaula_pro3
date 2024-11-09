package org.ecopaula.server.controller;

import org.ecopaula.server.dto.AnimalDTO;
import org.ecopaula.server.entity.Origin;
import org.ecopaula.server.service.AnimalService;
import org.hamcrest.Matchers;
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
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class AnimalControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnimalService animalService;

    @Autowired
    private ObjectMapper objectMapper;

    private AnimalDTO sampleAnimal;

    @BeforeEach
    public void setup() {
        sampleAnimal = new AnimalDTO();
        sampleAnimal.setId(1);
        sampleAnimal.setWeight(250.5);
        sampleAnimal.setRegistrationDate(new Date());
        sampleAnimal.setOrigin(new Origin());
    }

    @Test
    public void testRegisterAnimal() throws Exception {
        when(animalService.createAnimal(any(AnimalDTO.class))).thenReturn(sampleAnimal);

        mockMvc.perform(post("/animals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleAnimal)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(sampleAnimal.getId()))
                .andExpect(jsonPath("$.weight").value(sampleAnimal.getWeight()))
                .andExpect(jsonPath("$.registrationDate").value(Matchers.matchesPattern(
                        "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}[+-]\\d{2}:\\d{2}"
                )))
                // Use jsonPath to check origin.id and origin.name_of_farm specifically
                .andExpect(jsonPath("$.origin.id").value(sampleAnimal.getOrigin().getId()))
                .andExpect(jsonPath("$.origin.name_of_farm").value(sampleAnimal.getOrigin().getName_of_farm()));
    }

    @Test
    public void testGetAllAnimals() throws Exception {
        when(animalService.getAllAnimals()).thenReturn(List.of(sampleAnimal));

        mockMvc.perform(get("/animals")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(sampleAnimal.getId()))
                .andExpect(jsonPath("$[0].weight").value(sampleAnimal.getWeight()));
    }
}
