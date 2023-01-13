package com.vuklorr.fileshared.entity.query;

import lombok.Data;

@Data
public class TagsWithRating {
    private int idFile;
    private int countTag;
    private double rating;

    public TagsWithRating(int idFile, int countTag, double rating) {
        this.idFile = idFile;
        this.countTag = countTag;
        this.rating = rating;
    }
}