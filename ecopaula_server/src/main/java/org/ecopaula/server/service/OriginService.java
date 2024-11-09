package org.ecopaula.server.service;

import org.ecopaula.server.dto.OriginDTO;
import org.ecopaula.server.entity.Origin;

import java.util.List;

public interface OriginService {
    OriginDTO getOriginById(int id);
    List<OriginDTO> getAllOrigins();
}
