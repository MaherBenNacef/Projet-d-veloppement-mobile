package com.example.projet;

public class Note {
    private String title,description;
    public Note(String title , String description){
        this.title=title;
        this.description=description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Note(){}
}
