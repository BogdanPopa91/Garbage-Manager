package com.bogdan.garbagecollector.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClientDTO implements Serializable {

    String name;
    int id;
    List<GarbageDTO> garbageList;

    public ClientDTO(int id, String name) {
        this.name = name;
        this.id = id;
        this.garbageList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<GarbageDTO> getGarbageList() {
        return garbageList;
    }

    public void addGarbage(GarbageDTO garbage) {
        garbageList.add(garbage);
    }

    public void addGarbage(List<GarbageDTO> garbageList) {
        this.garbageList.addAll(garbageList);
    }
}
