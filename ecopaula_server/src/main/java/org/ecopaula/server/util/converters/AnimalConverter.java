package org.ecopaula.server.util.converters;

import dto.AnimalDTO;
import entity.Animal;
import org.springframework.stereotype.Component;

@Component
public class AnimalConverter {
    public Animal toEntity(AnimalDTO animalDTO) {
        Animal animal = new Animal();
        animal.setId(animalDTO.getId());
        animal.setWeight(animalDTO.getWeight());
        animal.setOrigin(animalDTO.getOrigin());
        animal.setRegistrationDate(animalDTO.getRegistrationDate());

        return animal;
    }

    public AnimalDTO toDto(Animal animal) {
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setId(animal.getId());
        animalDTO.setWeight(animal.getWeight());
        animalDTO.setOrigin(animal.getOrigin());
        animalDTO.setRegistrationDate(animal.getRegistrationDate());

        return animalDTO;
    }
}
