package org.ecopaula.station2;

import dto.AnimalDTO;
import org.ecopaula.station2.rabbitMQ.TrayProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/station2")
public class DissectionController {
    @Autowired
    TrayProducer producer;

    @PostMapping("/dissect")
    public ResponseEntity<String> dissectAnimal(@RequestBody AnimalDTO animal) {


        return ResponseEntity.ok("Animal dissected with success!");
    }
}
