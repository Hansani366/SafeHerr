package com.example.miniproject;

public class CallLogModel {
    String id;
    String name;
    String number;
    int imageRes;

    public CallLogModel() {
        // Required for Firebase
    }

    public CallLogModel(String id, String name, String number, int imageRes) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.imageRes = imageRes;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public int getImageRes() { return imageRes; }
    public void setImageRes(int imageRes) { this.imageRes = imageRes; }
}
