package com.example.paulap.crowdsourcing.Models;

import android.location.Location;

import java.util.Date;

public class Event {
    private Date data;
    private Location l;
    private String goal;
    private String category;

    public Event(Date data, Location l, String goal, String category) {
        this.data = data;
        this.l = l;
        this.goal = goal;
        this.category = category;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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
