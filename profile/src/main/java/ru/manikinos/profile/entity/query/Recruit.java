package ru.manikinos.profile.entity.query;

import java.time.LocalDate;

public class Recruit {
    private String name;
    private String patronymic;
    private String surname;
    private LocalDate dateRecruit;

    public Recruit(String name, String patronymic, String surname, LocalDate dateRecruit) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.dateRecruit = dateRecruit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateRecruit() {
        return dateRecruit;
    }

    public void setDateRecruit(LocalDate dateRecruit) {
        this.dateRecruit = dateRecruit;
    }
}
