package com.bogdan.garbagecollector.entity;

import com.bogdan.garbagecollector.dto.GarbageType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RecyclingCenter {

    private final int id;
    private String name;
    private final Set<GarbageType> recyclingTypes;

    public RecyclingCenter(int id, String name, Set<GarbageType> recyclingTypes) {
        this.id = id;
        this.name = name;
        this.recyclingTypes = recyclingTypes;
        //recyclingTypes = new HashSet<>();
    }

    public RecyclingCenter(int id, String name) {
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

    public void addRecyclingType(GarbageType type) {
        recyclingTypes.add(type);
    }

    public void removeRecyclingType(GarbageType type) {
        recyclingTypes.remove(type);
    }

    public void setName(String name) {
        this.name = name;
    }
}
