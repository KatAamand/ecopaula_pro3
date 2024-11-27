package org.ecopaula.server.service;

import dto.AnimalDTO;
import entity.Animal;
import org.ecopaula.server.repository.AnimalRepository;
import org.ecopaula.server.util.converters.AnimalConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {

    private AnimalRepository animalRepository;
    private AnimalConverter animalConverter;

    public AnimalServiceImpl(AnimalRepository animalRepository, AnimalConverter animalConverter) {
        this.animalRepository = animalRepository;
        this.animalConverter = animalConverter;
    }

    @Override
    public AnimalDTO createAnimal(AnimalDTO animalDTO) {
        Animal animal = animalConverter.toEntity(animalDTO);

        Animal savedAnimal = animalRepository.save(animal);

        return animalConverter.toDto(savedAnimal);
    }

    @Override
    public AnimalDTO getAnimalById(int id) {
        return animalRepository.findById(id)
                .map(animalConverter::toDto)
                .orElse(null);
    }

    @Override
    public List<AnimalDTO> getAllAnimals() {
        List<Animal> animals = animalRepository.findAll();
        return animals.stream().map(animalConverter::toDto).collect(Collectors.toList());
    }

    @Override
    public List<AnimalDTO> getAnimalsByProductId(int productId) {
       List<Animal> animals = animalRepository.findAnimalsByProductId(productId);

       return animals.stream().map(animalConverter::toDto).collect(Collectors.toList());
    }
}
