package org.ecopaula.server.service;

import org.ecopaula.server.dto.AnimalDTO;
import org.ecopaula.server.entity.Origin;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AnimalServiceImplTest {

    @Autowired
    private AnimalServiceImpl animalService;

    @Test
    void createAnimal() {
        Origin origin = new Origin(1, "testFarm");
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setWeight(500);
        animalDTO.setRegistrationDate(new Date());
        animalDTO.setOrigin(origin);

        AnimalDTO createdAnimalDTO = animalService.createAnimal(animalDTO);

        assertNotNull(createdAnimalDTO);
    }

    @Test
    void getAnimalById() {
        AnimalDTO animalDTO = animalService.getAnimalById(1);
        assertNotNull(animalDTO);
    }

    @Test
    void getAllAnimals() {
        List<AnimalDTO> listOfAnimals = animalService.getAllAnimals();
        assertNotNull(listOfAnimals);
    }

    @Test
    void getAnimalsByProductId() {
       List<AnimalDTO> listOfAnimals = animalService.getAnimalsByProductId(1);
       assertNotNull(listOfAnimals);
    }
}