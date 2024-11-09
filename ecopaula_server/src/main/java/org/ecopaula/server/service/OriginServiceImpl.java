package org.ecopaula.server.service;

import org.ecopaula.server.dto.OriginDTO;
import org.ecopaula.server.entity.Origin;
import org.ecopaula.server.repository.OriginRepository;
import org.ecopaula.server.util.converters.OriginConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OriginServiceImpl implements OriginService {
    private OriginRepository originRepository;
    private OriginConverter originConverter;

    public OriginServiceImpl(OriginRepository originRepository, OriginConverter originConverter) {
        this.originRepository = originRepository;
        this.originConverter = originConverter;
    }

    @Override
    public OriginDTO getOriginById(int id) {
        return originRepository.findById(id).map(originConverter::toDTO).orElse(null);
    }

    @Override
    public List<OriginDTO> getAllOrigins() {
        List<Origin> origins = originRepository.findAll();
        return origins.stream().map(originConverter::toDTO).collect(Collectors.toList());
    }
}
