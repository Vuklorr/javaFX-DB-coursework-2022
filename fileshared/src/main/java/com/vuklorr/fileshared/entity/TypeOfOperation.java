package com.vuklorr.fileshared.entity;

import lombok.Data;

@Data
public class TypeOfOperation {
    private int id;
    private String name;

    public TypeOfOperation(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
