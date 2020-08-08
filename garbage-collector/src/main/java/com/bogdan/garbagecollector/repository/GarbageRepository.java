package com.bogdan.garbagecollector.repository;

import com.bogdan.garbagecollector.dto.GarbageDTO;
import com.bogdan.garbagecollector.entity.Client;
import com.bogdan.garbagecollector.entity.Garbage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class GarbageRepository {

    private List<Garbage> garbagePacks;

    @Autowired
    public GarbageRepository(){
        garbagePacks = new ArrayList<>();
    }

    public String create(Garbage garbage) {
        garbagePacks.add(garbage);
        return "ok";
    }

    public List<Garbage> readAll() {
        return garbagePacks;
    }

    public Optional<Garbage> readByID(int id) {
        return getOptionalGarbage(id);
    }

    private Optional<Garbage> getOptionalGarbage(int id) {
        return garbagePacks.stream()
                           .filter(garbage -> garbage.getId() == id)
                           .findFirst();
    }

    public String update(int id, Garbage oldGarbage) {
        garbagePacks.remove(id); //TODO: fix this
        garbagePacks.add(oldGarbage);
        return "ok";
    }

    public boolean delete(Garbage garbage) {
        garbagePacks.remove(garbage);
        return true;
    }
}
