package org.ecopaula.server.controller;

import org.ecopaula.server.dto.AnimalDTO;
import org.ecopaula.server.entity.Origin;
import org.ecopaula.server.service.AnimalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AnimalController.class)
public class AnimalControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnimalService animalService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testRegisterAnimal() throws Exception {
        // Arrange
        Origin origin = new Origin(1, "Farm A");
        AnimalDTO animalDTO = new AnimalDTO(1, 250.5, new Date(), origin);

        when(animalService.createAnimal(any(AnimalDTO.class))).thenReturn(animalDTO);

        // Act & Assert
        mockMvc.perform(post("/animals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(animalDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(animalDTO.getId()))
                .andExpect(jsonPath("$.weight").value(animalDTO.getWeight()))
                .andExpect(jsonPath("$.origin.name_of_farm").value(animalDTO.getOrigin().getName_of_farm()));
    }

    @Test
    public void testGetAllAnimals() throws Exception {
        // Arrange
        Origin origin = new Origin(1, "Farm A");
        AnimalDTO animal1 = new AnimalDTO(1, 250.5, new Date(), origin);
        AnimalDTO animal2 = new AnimalDTO(2, 180.0, new Date(), origin);
        List<AnimalDTO> animals = List.of(animal1, animal2);

        when(animalService.getAllAnimals()).thenReturn(animals);

        // Act & Assert
        mockMvc.perform(get("/animals")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(animals.size()))
                .andExpect(jsonPath("$[0].id").value(animal1.getId()))
                .andExpect(jsonPath("$[0].weight").value(animal1.getWeight()))
                .andExpect(jsonPath("$[1].id").value(animal2.getId()))
                .andExpect(jsonPath("$[1].weight").value(animal2.getWeight()));
    }
}
