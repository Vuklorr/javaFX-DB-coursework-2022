package ru.manikinos.profile.entity.query;

public class PrivateContact {
    private String namePerson;
    private String phoneNumberPerson;
    private String nameRelative;
    private String phoneNumberRelative;

    public PrivateContact(String namePerson, String phoneNumberPerson, String nameRelative, String phoneNumberRelative) {
        this.namePerson = namePerson;
        this.phoneNumberPerson = phoneNumberPerson;
        this.nameRelative = nameRelative;
        this.phoneNumberRelative = phoneNumberRelative;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getPhoneNumberPerson() {
        return phoneNumberPerson;
    }

    public void setPhoneNumberPerson(String phoneNumberPerson) {
        this.phoneNumberPerson = phoneNumberPerson;
    }

    public String getNameRelative() {
        return nameRelative;
    }

    public void setNameRelative(String nameRelative) {
        this.nameRelative = nameRelative;
    }

    public String getPhoneNumberRelative() {
        return phoneNumberRelative;
    }

    public void setPhoneNumberRelative(String phoneNumberRelative) {
        this.phoneNumberRelative = phoneNumberRelative;
    }
}
