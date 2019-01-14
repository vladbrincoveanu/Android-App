package com.example.paulap.crowdsourcing.Models;

import android.location.Location;

import java.util.Date;

public class Event {
    private String title;
    private String data;
    private String location;
    private String goal;
    private String category;

    public Event(String title,String data, String location, String goal, String category) {
        this.title =title;
        this.data = data;
        this.location = location;
        this.goal = goal;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getL() {
        return location;
    }

    public void setL(String l) {
        this.location = l;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
