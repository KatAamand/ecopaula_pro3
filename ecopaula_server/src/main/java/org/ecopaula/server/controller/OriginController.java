package org.ecopaula.server.controller;

import dto.OriginDTO;
import org.ecopaula.server.service.OriginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/origins")
public class OriginController {
    private final OriginService originService;

    public OriginController(OriginService originService) {
        this.originService = originService;
    }

    @GetMapping
    public ResponseEntity<List<OriginDTO>> getAllOrigins() {
        return ResponseEntity.ok(originService.getAllOrigins());
    }
}
