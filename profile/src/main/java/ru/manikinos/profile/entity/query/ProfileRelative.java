package ru.manikinos.profile.entity.query;

public class ProfileRelative {
    private Profile profile;
    private String typeRelative;

    public ProfileRelative(Profile profile, String typeRelative) {
        this.profile = profile;
        this.typeRelative = typeRelative;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getTypeRelative() {
        return typeRelative;
    }

    public void setTypeRelative(String typeRelative) {
        this.typeRelative = typeRelative;
    }
}
