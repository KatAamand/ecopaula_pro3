package org.ecopaula.server.service;

import org.ecopaula.server.dto.AnimalDTO;
import org.ecopaula.server.entity.Animal;

import java.util.List;

public interface AnimalService {
    AnimalDTO createAnimal(AnimalDTO animalDTO);
    AnimalDTO getAnimalById(int id);

    List<AnimalDTO> getAllAnimals();
    List<AnimalDTO> getAnimalsByProductId(int productId);
}
