package com.bogdan.garbagecollector.service;

import com.bogdan.garbagecollector.dto.AddOrRemove;
import com.bogdan.garbagecollector.dto.GarbageType;
import com.bogdan.garbagecollector.dto.RecyclingCenterDTO;
import com.bogdan.garbagecollector.entity.RecyclingCenter;
import com.bogdan.garbagecollector.repository.RecyclingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecyclingCenterService {

    private final RecyclingCenterRepository recyclingCenterRepository;
    private RecyclingCenter entity;

    @Autowired
    public RecyclingCenterService(RecyclingCenterRepository recyclingCenterRepository) {
        this.recyclingCenterRepository = recyclingCenterRepository;
    }

    private RecyclingCenter convertDTOToEntity(RecyclingCenterDTO dto) {
        RecyclingCenter entity = new RecyclingCenter(dto.getId(), dto.getName(), dto.getRecyclingTypes());
        return entity;
    }

    private RecyclingCenterDTO convertEntityToDTO(RecyclingCenter entity) {
        RecyclingCenterDTO dto = new RecyclingCenterDTO(entity.getId(), entity.getName(), entity.getRecyclingTypes());
        return dto;
    }

    public String create(RecyclingCenterDTO recyclingCenterDTO) {
        RecyclingCenter recyclingCenter = convertDTOToEntity(recyclingCenterDTO);
        return recyclingCenterRepository.create(recyclingCenter);
    }

    public List<RecyclingCenterDTO> readAll() {
        return recyclingCenterRepository.readAll()
                                        .stream()
                                        .map(this::convertEntityToDTO)
                                        .collect(Collectors.toList());
    }

    public RecyclingCenterDTO read(int id) {
        RecyclingCenter recyclingCenterById = getEntityByIdOrThrow(id);
        return convertEntityToDTO(recyclingCenterById);
    }

    private RecyclingCenter getEntityByIdOrThrow(int id) {
        return recyclingCenterRepository.readById(id)
                                        .orElseThrow(() -> new IllegalArgumentException("There is no recycling center with the id " + id));
    }

    public String updateName(int id, String name) {
        RecyclingCenter recyclingCenterById = getEntityByIdOrThrow(id);
        recyclingCenterById.setName(name);
        return recyclingCenterRepository.update(id, recyclingCenterById);
    }

    public String addGarbageTypes(int id, GarbageType garbageType) {
        RecyclingCenter recyclingCenterById = getEntityByIdOrThrow(id);
        recyclingCenterById.addRecyclingType(garbageType);
        return recyclingCenterRepository.update(id,recyclingCenterById);
    }

    public String removeGarbageTypes(int id, GarbageType garbageType) {
        RecyclingCenter recyclingCenterById = getEntityByIdOrThrow(id);
        recyclingCenterById.removeRecyclingType(garbageType);
        return recyclingCenterRepository.update(id,recyclingCenterById);
    }

    public String delete(int id) {
        RecyclingCenter recyclingCenterById = getEntityByIdOrThrow(id);
        boolean deleted = recyclingCenterRepository.delete(recyclingCenterById);
        return deleted ? "ok" : "not ok";
    }
}
