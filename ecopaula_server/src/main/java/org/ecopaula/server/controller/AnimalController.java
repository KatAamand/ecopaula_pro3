package org.ecopaula.ecopaula_server.controller;

import org.ecopaula.ecopaula_server.dto.AnimalDTO;
import org.ecopaula.ecopaula_server.repository.AnimalRepository;
import org.ecopaula.ecopaula_server.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public ResponseEntity<AnimalDTO> registerAnimal(@RequestBody AnimalDTO animalDTO) {
        return ResponseEntity.ok(animalService.createAnimal(animalDTO));
    }
}
