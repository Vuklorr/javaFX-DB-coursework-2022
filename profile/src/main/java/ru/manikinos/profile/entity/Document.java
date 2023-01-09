package ru.manikinos.profile.entity;

import java.time.LocalDate;

public class Document {
    private int id;
    private int idType;
    private int idPersonalData;
    private LocalDate startDate;
    private LocalDate endDate;

    public Document(int id, int idType, int idPersonalData, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.idType = idType;
        this.idPersonalData = idPersonalData;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getIdPersonalData() {
        return idPersonalData;
    }

    public void setIdPersonalData(int idPersonalData) {
        this.idPersonalData = idPersonalData;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
