package org.ecopaula.server.service;

import dto.AnimalDTO;

import java.util.List;

public interface AnimalService {
    AnimalDTO createAnimal(AnimalDTO animalDTO);
    AnimalDTO getAnimalById(int id);

    List<AnimalDTO> getAllAnimals();
    List<AnimalDTO> getAnimalsByProductId(int productId);
}
