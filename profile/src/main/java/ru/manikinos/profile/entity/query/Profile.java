package ru.manikinos.profile.entity.query;

public class Profile {
    private String name;
    private String patronymic;
    private String surname;
    private String phoneNumber;
    private String country;
    private String city;
    private String region;
    private String street;
    private String house;
    private int flat;

    public Profile(String name, String patronymic, String surname, String phoneNumber, String country, String city, String region, String street, String house, int flat) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.city = city;
        this.region = region;
        this.street = street;
        this.house = house;
        this.flat = flat;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }
}
