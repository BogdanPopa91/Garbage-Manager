package com.bogdan.garbagecollector.service;

import com.bogdan.garbagecollector.dto.GarbageDTO;
import com.bogdan.garbagecollector.entity.Garbage;
import com.bogdan.garbagecollector.repository.GarbageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GarbageService {

    private final GarbageRepository garbageRepository;

    @Autowired
    public GarbageService(GarbageRepository garbageRepository){
        this.garbageRepository = garbageRepository;
    }

    public String create(GarbageDTO garbageDTO) {
        return garbageRepository.create(convertDTOToGarbage().apply(garbageDTO));
    }

    private Function<GarbageDTO, Garbage> convertDTOToGarbage() {
        return garbageDTO -> new Garbage(garbageDTO.getId(), garbageDTO.getState(),
                                         garbageDTO.getQuantity(), garbageDTO.getType());
    }

    private Function<Garbage, GarbageDTO> convertGarbageToDTO() {
        return garbage -> new GarbageDTO(garbage.getId(), garbage.getState(),
                                         garbage.getQuantity(), garbage.getType());
    }

    public List<GarbageDTO> readAll() {
        return garbageRepository.readAll()
                                .stream()
                                .map(convertGarbageToDTO())
                                .collect(Collectors.toList());
    }

    public GarbageDTO readByID(int id) {
        Garbage garbageById = getGarbageByIdOrThrow(id);
        return convertGarbageToDTO().apply(garbageById);
    }

    private Garbage getGarbageByIdOrThrow(int id) {
        return garbageRepository.readByID(id)
                                .orElseThrow(() -> new IllegalArgumentException("There is no garbage with the id " + id));
    }

    public String update(int id, GarbageDTO newGarbage) {
        Garbage oldGarbage = getGarbageByIdOrThrow(id);
        oldGarbage.setState(newGarbage.getState());
        oldGarbage.setQuantity(newGarbage.getQuantity());
        oldGarbage.setType(newGarbage.getType());
        return garbageRepository.update(id, oldGarbage);
    }

    public String delete(int id) {
        Garbage garbageById = getGarbageByIdOrThrow(id);
        boolean deleted = garbageRepository.delete(garbageById);
        return deleted ? "ok" : "not ok";
    }
}
