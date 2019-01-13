package com.example.paulap.crowdsourcing.Models;

import android.location.Location;

import java.util.Date;

public class Event {
    private String title;
    private String data;
    private Location l;
    private String goal;
    private String category;

    public Event(String title,String data, Location l, String goal, String category) {
        this.title =title;
        this.data = data;
        this.l = l;
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

    public Location getL() {
        return l;
    }

    public void setL(Location l) {
        this.l = l;
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
