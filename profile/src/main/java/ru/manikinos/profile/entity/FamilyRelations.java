package ru.manikinos.profile.entity;

public class FamilyRelations {
    int idFirstPerson;
    int idSecondPerson;
    int idTypeOfRelationship;

    public FamilyRelations(int idFirstPerson, int idSecondPerson, int idTypeOfRelationship) {
        this.idFirstPerson = idFirstPerson;
        this.idSecondPerson = idSecondPerson;
        this.idTypeOfRelationship = idTypeOfRelationship;
    }

    public int getIdFirstPerson() {
        return idFirstPerson;
    }

    public void setIdFirstPerson(int idFirstPerson) {
        this.idFirstPerson = idFirstPerson;
    }

    public int getIdSecondPerson() {
        return idSecondPerson;
    }

    public void setIdSecondPerson(int idSecondPerson) {
        this.idSecondPerson = idSecondPerson;
    }

    public int getIdTypeOfRelationship() {
        return idTypeOfRelationship;
    }

    public void setIdTypeOfRelationship(int idTypeOfRelationship) {
        this.idTypeOfRelationship = idTypeOfRelationship;
    }
}
