package org.ecopaula.server.service;

import dto.OriginDTO;

import java.util.List;

public interface OriginService {
    OriginDTO getOriginById(int id);
    List<OriginDTO> getAllOrigins();
}
