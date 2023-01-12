package com.vuklorr.fileshared.entity.query;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DownloadedFilesExcludingLastThree {
    private int id;
    private String name;
    private String path;
    private int size;
    private LocalDate dateOfOperation;

    public DownloadedFilesExcludingLastThree(int id, String name, String path, int size, LocalDate dateOfOperation) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.size = size;
        this.dateOfOperation = dateOfOperation;
    }
}