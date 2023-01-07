package ru.manikinos.profile.entity.query;

public class AllDocuments {
    private String nameDocument;
    private int countDocument;

    public AllDocuments(String nameDocument, int countDocument) {
        this.nameDocument = nameDocument;
        this.countDocument = countDocument;
    }

    public String getNameDocument() {
        return nameDocument;
    }

    public void setNameDocument(String nameDocument) {
        this.nameDocument = nameDocument;
    }

    public int getCountDocument() {
        return countDocument;
    }

    public void setCountDocument(int countDocument) {
        this.countDocument = countDocument;
    }
}
