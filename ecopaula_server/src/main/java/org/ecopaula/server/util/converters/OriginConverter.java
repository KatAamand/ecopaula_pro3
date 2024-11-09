package org.ecopaula.server.util.converters;

import org.ecopaula.server.dto.OriginDTO;
import org.ecopaula.server.entity.Origin;
import org.springframework.stereotype.Component;

@Component
public class OriginConverter {
    public Origin toEntity(OriginDTO originDTO) {
        Origin origin = new Origin();
        origin.setId(originDTO.getId());
        origin.setName_of_farm(originDTO.getName_of_farm());

        return origin;
    }

    public OriginDTO toDTO(Origin origin) {
        OriginDTO originDTO = new OriginDTO();
        originDTO.setId(origin.getId());
        originDTO.setName_of_farm(origin.getName_of_farm());
        return originDTO;
    }
}
