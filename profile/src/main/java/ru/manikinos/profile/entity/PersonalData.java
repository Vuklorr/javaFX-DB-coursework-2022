package ru.manikinos.profile.entity;

public class PersonalData {
    private int id;
    private int idAddress;
    private String name;
    private String patronymic;
    private String surname;
    private String phoneNumber;

    public PersonalData(int id, int idAddress, String name, String patronymic, String surname, String phoneNumber) {
        this.id = id;
        this.idAddress = idAddress;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
