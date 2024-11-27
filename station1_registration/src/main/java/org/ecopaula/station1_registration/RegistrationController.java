package org.ecopaula.station1_registration;

import dto.AnimalDTO;
import org.ecopaula.station1_registration.rabbitMQ.Station1Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/station1")
public class RegistrationController {

    @Autowired
    Station1Producer producer;

    @PostMapping("/register")
    public ResponseEntity<String> RegisterAnimal(@RequestBody AnimalDTO animalDTO) {
        producer.sendToServer(animalDTO);
        producer.sendToStation2(animalDTO);

        return ResponseEntity.ok("Animal registered with success!");
    }

}
