package com.vuklorr.fileshared.entity.query;

import lombok.Data;

@Data
public class FileOperationsWithClient {
    private String nameOperation;
    private String nameClient;
    private String patronymicClient;
    private String surnameClient;

    public FileOperationsWithClient(String nameOperation, String nameClient, String patronymicClient, String surnameClient) {
        this.nameOperation = nameOperation;
        this.nameClient = nameClient;
        this.patronymicClient = patronymicClient;
        this.surnameClient = surnameClient;
    }
}