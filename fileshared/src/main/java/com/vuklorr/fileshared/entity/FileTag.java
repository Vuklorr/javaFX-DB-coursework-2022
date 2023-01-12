package com.vuklorr.fileshared.entity;

import lombok.Data;

@Data
public class FileTag {
    private int idFile;
    private int idTag;

    public FileTag(int idFile, int idTag) {
        this.idFile = idFile;
        this.idTag = idTag;
    }
}