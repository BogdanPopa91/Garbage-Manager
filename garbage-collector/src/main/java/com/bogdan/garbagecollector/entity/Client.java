package com.bogdan.garbagecollector.entity;

import com.bogdan.garbagecollector.dto.GarbageDTO;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Client {
    String name;
    @Id
    int id;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Garbage> garbageList;

    public Client() {
    }

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Garbage> getGarbageList() {
        return garbageList;
    }

    public void setGarbageList(List<Garbage> garbageList) {
        this.garbageList = garbageList;
    }
}
