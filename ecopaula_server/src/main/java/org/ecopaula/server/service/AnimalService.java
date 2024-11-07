package org.ecopaula.ecopaula_server.service;

import org.ecopaula.ecopaula_server.dto.AnimalDTO;

public interface AnimalService {
    AnimalDTO createAnimal(AnimalDTO animal);
    AnimalDTO getAnimalById(int id);
}
