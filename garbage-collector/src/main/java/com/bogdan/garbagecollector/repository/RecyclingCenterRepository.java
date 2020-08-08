package com.bogdan.garbagecollector.repository;

import com.bogdan.garbagecollector.dto.GarbageType;
import com.bogdan.garbagecollector.dto.RecyclingCenterDTO;
import com.bogdan.garbagecollector.entity.RecyclingCenter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Repository
public class RecyclingCenterRepository {

    private final List<RecyclingCenter> list;

    public RecyclingCenterRepository() {

        RecyclingCenter recyclingCenter1 = new RecyclingCenter(1,"Metalurgiei", new HashSet<>());
        RecyclingCenter recyclingCenter2 = new RecyclingCenter(2,"Plasticului", new HashSet<>());
        RecyclingCenter recyclingCenter3 = new RecyclingCenter(3,"Hartiei", new HashSet<>());
        RecyclingCenter recyclingCenter4 = new RecyclingCenter(4,"Universal", new HashSet<>());


        recyclingCenter1.addRecyclingType(GarbageType.Metal);
        recyclingCenter2.addRecyclingType(GarbageType.Plastic);
        recyclingCenter3.addRecyclingType(GarbageType.Paper);
        recyclingCenter4.addRecyclingType(GarbageType.Metal);
        recyclingCenter4.addRecyclingType(GarbageType.Plastic);
        recyclingCenter4.addRecyclingType(GarbageType.Paper);

        list = new ArrayList<>();
        list.add(recyclingCenter1);
        list.add(recyclingCenter2);
        list.add(recyclingCenter3);
        list.add(recyclingCenter4);
    }

    public String create(RecyclingCenter recyclingCenter) {
        list.add(recyclingCenter);
        return "ok";
    }

    public List<RecyclingCenter> readAll() {
        return list;
    }

    public Optional<RecyclingCenter> readById(int id) {
        return list.stream()
                   .filter(entity -> entity.getId() == id)
                   .findFirst();
    }

    public String update(int id, RecyclingCenter recyclingCenterById) {
        RecyclingCenter oldRecyclingCenter = list.stream()
                                                 .filter(entity -> entity.getId() == id)
                                                 .findFirst()
                                                 .get();
        list.remove(oldRecyclingCenter);
        list.add(recyclingCenterById);
        return "ok";
    }

    public boolean delete(RecyclingCenter recyclingCenterById) {
        return list.remove(recyclingCenterById);
    }
}
