package ru.manikinos.profile.entity;

public class Address {
    private int id;
    private String country;
    private String city;
    private String region;
    private String street;
    private String house;
    private int flat;

    public Address(int id, String country, String city, String region, String street, String house, int flat) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.region = region;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
