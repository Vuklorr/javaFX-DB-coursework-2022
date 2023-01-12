package com.vuklorr.fileshared.entity.query;

import lombok.Data;

@Data
public class TopThreeMostAccessibleFiles {
    private int idFile;
    private String nameFile;
    private int countClient;

    public TopThreeMostAccessibleFiles(int idFile, String nameFile, int countClient) {
        this.idFile = idFile;
        this.nameFile = nameFile;
        this.countClient = countClient;
    }
}