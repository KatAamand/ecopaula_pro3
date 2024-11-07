package org.ecopaula.server.controller;

import org.ecopaula.server.dto.AnimalDTO;
import org.ecopaula.server.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
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

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAllAnimals() {
        return ResponseEntity.ok(animalService.getAllAnimals());
    }
}
