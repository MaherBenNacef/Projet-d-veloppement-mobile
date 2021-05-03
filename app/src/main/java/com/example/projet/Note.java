package com.example.projet;

public class Note {
    private String title,description,userId,phone;

    public Note(String title , String description,String userId,String phone){
        this.title=title;
        this.description=description;
        this.userId=userId;
        this.phone=phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUserId() {
        return userId;
    }

    public Note(){}
}
