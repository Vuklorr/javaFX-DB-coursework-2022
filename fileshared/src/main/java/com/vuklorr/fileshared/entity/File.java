package com.vuklorr.fileshared.entity;

import lombok.Data;

@Data
public class File {
    private int id;
    private String name;
    private String path;
    private int size;

    public File(int id, String name, String path, int size) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.size = size;
    }
}