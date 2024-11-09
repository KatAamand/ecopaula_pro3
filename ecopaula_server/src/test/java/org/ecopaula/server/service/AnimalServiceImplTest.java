package org.ecopaula.server.service;

import org.ecopaula.server.dto.AnimalDTO;
import org.ecopaula.server.entity.Animal;
import org.ecopaula.server.entity.Origin;
import org.ecopaula.server.repository.AnimalRepository;
import org.ecopaula.server.util.converters.AnimalConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class AnimalServiceImplTest {

    @Mock
    private AnimalRepository animalRepository;

    @Mock
    private AnimalConverter animalConverter;

    @InjectMocks
    private AnimalServiceImpl animalService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAnimal() {
        AnimalDTO animalDTO = new AnimalDTO();
        Animal animal = new Animal();
        when(animalConverter.toEntity(animalDTO)).thenReturn(animal);
        when(animalRepository.save(animal)).thenReturn(animal);
        when(animalConverter.toDto(animal)).thenReturn(animalDTO);

        AnimalDTO result = animalService.createAnimal(animalDTO);

        assertNotNull(result);
        verify(animalRepository, times(1)).save(animal);
        verify(animalConverter, times(1)).toEntity(animalDTO);
        verify(animalConverter, times(1)).toDto(animal);    }

    @Test
    void getAnimalById() {
        int animalId = 1;
        Animal animal = new Animal();
        AnimalDTO animalDTO = new AnimalDTO();
        when(animalRepository.findById(animalId)).thenReturn(Optional.of(animal));
        when(animalConverter.toDto(animal)).thenReturn(animalDTO);

        AnimalDTO result = animalService.getAnimalById(animalId);

        assertNotNull(result);
        assertEquals(animalDTO, result);
        verify(animalRepository, times(1)).findById(animalId);
        verify(animalConverter, times(1)).toDto(animal);
    }

    @Test
    void getAllAnimals() {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        List<Animal> animals = Arrays.asList(animal1, animal2);

        AnimalDTO animalDTO1 = new AnimalDTO();
        AnimalDTO animalDTO2 = new AnimalDTO();
        List<AnimalDTO> animalDTOs = Arrays.asList(animalDTO1, animalDTO2);

        when(animalRepository.findAll()).thenReturn(animals);
        when(animalConverter.toDto(animal1)).thenReturn(animalDTO1);
        when(animalConverter.toDto(animal2)).thenReturn(animalDTO2);

        List<AnimalDTO> result = animalService.getAllAnimals();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(animalRepository, times(1)).findAll();
        verify(animalConverter, times(1)).toDto(animal1);
        verify(animalConverter, times(1)).toDto(animal2);
    }

    @Test
    void getAnimalsByProductId() {
        int productId = 1;
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        List<Animal> animals = Arrays.asList(animal1, animal2);

        AnimalDTO animalDTO1 = new AnimalDTO();
        AnimalDTO animalDTO2 = new AnimalDTO();
        List<AnimalDTO> animalDTOs = Arrays.asList(animalDTO1, animalDTO2);

        when(animalRepository.findAnimalsByProductId(productId)).thenReturn(animals);
        when(animalConverter.toDto(animal1)).thenReturn(animalDTO1);
        when(animalConverter.toDto(animal2)).thenReturn(animalDTO2);

        List<AnimalDTO> result = animalService.getAnimalsByProductId(productId);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(animalRepository, times(1)).findAnimalsByProductId(productId);
        verify(animalConverter, times(1)).toDto(animal1);
        verify(animalConverter, times(1)).toDto(animal2);
    }
}