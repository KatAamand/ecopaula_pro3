package org.ecopaula.station1_registration;

import dto.AnimalDTO;
import org.ecopaula.station1_registration.rabbitMQ.Station1Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/station1")
public class RegistrationController {

    Station1Producer producer;

    public RegistrationController(Station1Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/register")
    public ResponseEntity<String> RegisterAnimal(@RequestBody AnimalDTO animalDTO) {
        producer.sendToServer(animalDTO);

        return ResponseEntity.ok("Animal registered with success!");
    }

}
