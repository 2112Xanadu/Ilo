package com.sovellus.ilo;

public class Kiitollisuuslista {
    String title;
    String description;
    long createdTime;

    public Kiitollisuuslista(String title, String description, long createdTime) {
        this.title = title;
        this.description = description;
        this.createdTime = createdTime;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
