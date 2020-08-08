package com.bogdan.garbagecollector.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class RecyclingCenterDTO implements Serializable {

    private final int id;
    private String name;
    private final Set<GarbageType> recyclingTypes;

    public RecyclingCenterDTO(int id, String name, Set<GarbageType> recyclingTypes) {
        this.id = id;
        this.name = name;
        this.recyclingTypes = recyclingTypes;
    }

    @JsonCreator
    public RecyclingCenterDTO(int id, String name) {
        this.id = id;
        this.name = name;
        recyclingTypes = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<GarbageType> getRecyclingTypes() {
        return recyclingTypes;
    }

    public void setName(String name) {
        this.name = name;
    }
}
