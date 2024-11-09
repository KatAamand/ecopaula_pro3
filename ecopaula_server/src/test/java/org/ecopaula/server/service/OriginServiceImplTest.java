package org.ecopaula.server.service;

import org.ecopaula.server.dto.OriginDTO;
import org.ecopaula.server.entity.Origin;
import org.ecopaula.server.repository.OriginRepository;
import org.ecopaula.server.util.converters.OriginConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OriginServiceImplTest {

    @Mock
    private OriginRepository originRepository;

    @Mock
    private OriginConverter originConverter;

    @InjectMocks
    private OriginServiceImpl originService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetOriginById_Found() {
        int originId = 1;
        Origin origin = new Origin(originId, "Farm A");
        OriginDTO originDTO = new OriginDTO(originId, "Farm A");

        when(originRepository.findById(originId)).thenReturn(Optional.of(origin));
        when(originConverter.toDTO(origin)).thenReturn(originDTO);

        OriginDTO result = originService.getOriginById(originId);

        assertNotNull(result);
        assertEquals(originDTO, result);
        verify(originRepository, times(1)).findById(originId);
        verify(originConverter, times(1)).toDTO(origin);
    }

    @Test
    public void testGetOriginById_NotFound() {
        int originId = 1;

        when(originRepository.findById(originId)).thenReturn(Optional.empty());

        OriginDTO result = originService.getOriginById(originId);

        assertNull(result);
        verify(originRepository, times(1)).findById(originId);
        verify(originConverter, never()).toDTO(any(Origin.class));
    }

    @Test
    public void testGetAllOrigins() {
        Origin origin1 = new Origin(1, "Farm A");
        Origin origin2 = new Origin(2, "Farm B");
        List<Origin> origins = Arrays.asList(origin1, origin2);

        OriginDTO originDTO1 = new OriginDTO(1, "Farm A");
        OriginDTO originDTO2 = new OriginDTO(2, "Farm B");
        List<OriginDTO> originDTOs = Arrays.asList(originDTO1, originDTO2);

        when(originRepository.findAll()).thenReturn(origins);
        when(originConverter.toDTO(origin1)).thenReturn(originDTO1);
        when(originConverter.toDTO(origin2)).thenReturn(originDTO2);

        List<OriginDTO> result = originService.getAllOrigins();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.containsAll(originDTOs));
        verify(originRepository, times(1)).findAll();
        verify(originConverter, times(1)).toDTO(origin1);
        verify(originConverter, times(1)).toDTO(origin2);
    }
}
