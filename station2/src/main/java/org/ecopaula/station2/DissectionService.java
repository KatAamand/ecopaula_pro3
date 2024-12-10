package org.ecopaula.station2;

import dto.AnimalDTO;
import entity.Cut;
import entity.PartType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DissectionService {

    public List<Cut> dissectAnimal(AnimalDTO animalDTO) {
        List<PartType> partTypes = getPartTypes();

        List<Cut> cuts = new ArrayList<>();
        double remainingWeight = animalDTO.getWeight();

        return cuts;
    }

    private List<PartType> getPartTypes() {
        return new ArrayList<>();
    }
}
