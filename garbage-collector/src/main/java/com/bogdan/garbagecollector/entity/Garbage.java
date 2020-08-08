package com.bogdan.garbagecollector.entity;

import com.bogdan.garbagecollector.dto.GarbageType;
import com.bogdan.garbagecollector.dto.RecyclingState;

import javax.persistence.*;

@Entity
public class Garbage {
    @Id
    int id;
    @Enumerated(value = EnumType.STRING)
    RecyclingState state;
    int quantity;
    @Enumerated(value = EnumType.STRING)
    GarbageType type;
    @ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Client client;

    public Garbage() {
    }

    public Garbage(int id, RecyclingState state, int quantity, GarbageType type) {
        this.id = id;
        this.state = state;
        this.quantity = quantity;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RecyclingState getState() {
        return state;
    }

    public void setState(RecyclingState state) {
        this.state = state;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public GarbageType getType() {
        return type;
    }

    public void setType(GarbageType type) {
        this.type = type;
    }
}
