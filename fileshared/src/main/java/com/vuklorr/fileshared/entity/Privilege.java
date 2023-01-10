package com.vuklorr.fileshared.entity;

import lombok.Data;

@Data
public class Privilege {
    private int id;
    private int idClient;
    private int idFile;

    public Privilege(int id, int idClient, int idFile) {
        this.id = id;
        this.idClient = idClient;
        this.idFile = idFile;
    }
}