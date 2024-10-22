package com.college.app.model;

public enum Role {
    STUDENT("Student"),
    FACULTY_MEMBER("Faculty Member"),
    ADMINISTRATOR("Administrator");
    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
