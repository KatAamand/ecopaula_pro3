package org.ecopaula.ecopaula_server.service;

import org.ecopaula.ecopaula_server.dto.AnimalDTO;
import org.ecopaula.ecopaula_server.repository.AnimalRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimalServiceImpl implements AnimalService {

    private AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public AnimalDTO createAnimal(AnimalDTO animal) {
        return null;
    }

    @Override
    public AnimalDTO getAnimalById(int id) {
        return null;
    }
}
