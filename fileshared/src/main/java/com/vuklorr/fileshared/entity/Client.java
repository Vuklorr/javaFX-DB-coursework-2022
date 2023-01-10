package com.vuklorr.fileshared.entity;

import lombok.Data;

@Data
public class Client {
    private int id;
    private String name;
    private String patronymic;
    private String surname;

    public Client(int id, String name, String patronymic, String surname) {
        this.id = id;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
    }
}
