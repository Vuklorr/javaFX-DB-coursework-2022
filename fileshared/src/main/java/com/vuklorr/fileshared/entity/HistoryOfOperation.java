package com.vuklorr.fileshared.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HistoryOfOperation {
    private int id;
    private int idTypeOfOperation;
    private int idClient;
    private int idFile;
    private LocalDate dateOfOperation;

    public HistoryOfOperation(int id, int idTypeOfOperation, int idClient, int idFile, LocalDate dateOfOperation) {
        this.id = id;
        this.idTypeOfOperation = idTypeOfOperation;
        this.idClient = idClient;
        this.idFile = idFile;
        this.dateOfOperation = dateOfOperation;
    }
}