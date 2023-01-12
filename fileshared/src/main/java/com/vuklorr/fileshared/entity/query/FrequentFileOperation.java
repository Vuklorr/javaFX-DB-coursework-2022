package com.vuklorr.fileshared.entity.query;

import lombok.Data;

@Data
public class FrequentFileOperation {
    private String nameOperation;
    private int countOperation;

    public FrequentFileOperation(String nameOperation, int countOperation) {
        this.nameOperation = nameOperation;
        this.countOperation = countOperation;
    }
}