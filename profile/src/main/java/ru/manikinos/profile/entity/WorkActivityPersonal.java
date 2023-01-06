package ru.manikinos.profile.entity;

import java.time.LocalDate;

public class WorkActivityPersonal {
    private int idPersonalData;
    private int idWork;
    private LocalDate dateOfHiring;
    private LocalDate dateOfDismissal;

    public WorkActivityPersonal(int idPersonalData, int idWork, LocalDate dateOfHiring, LocalDate dateOfDismissal) {
        this.idPersonalData = idPersonalData;
        this.idWork = idWork;
        this.dateOfHiring = dateOfHiring;
        this.dateOfDismissal = dateOfDismissal;
    }

    public int getIdPersonalData() {
        return idPersonalData;
    }

    public void setIdPersonalData(int idPersonalData) {
        this.idPersonalData = idPersonalData;
    }

    public int getIdWork() {
        return idWork;
    }

    public void setIdWork(int idWork) {
        this.idWork = idWork;
    }

    public LocalDate getDateOfHiring() {
        return dateOfHiring;
    }

    public void setDateOfHiring(LocalDate dateOfHiring) {
        this.dateOfHiring = dateOfHiring;
    }

    public LocalDate getDateOfDismissal() {
        return dateOfDismissal;
    }

    public void setDateOfDismissal(LocalDate dateOfDismissal) {
        this.dateOfDismissal = dateOfDismissal;
    }
}
