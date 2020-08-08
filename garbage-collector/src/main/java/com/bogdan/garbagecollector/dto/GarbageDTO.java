package com.bogdan.garbagecollector.dto;

import java.io.Serializable;

public class GarbageDTO implements Serializable {

    int id;
    RecyclingState state;
    int quantity;
    GarbageType type;

    public GarbageDTO(int id,RecyclingState state, int quantity, GarbageType type) {
        this.id = id;
        this.state = state;
        this.quantity = quantity;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public RecyclingState getState() {
        return state;
    }

    public int getQuantity() {
        return quantity;
    }

    public GarbageType getType() {
        return type;
    }
}
