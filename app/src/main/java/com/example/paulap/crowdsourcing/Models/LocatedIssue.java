package com.example.paulap.crowdsourcing.Models;

import java.io.Serializable;

public class LocatedIssue implements Serializable {

    private String summary;
    private double longitude;
    private double latitude;

    public LocatedIssue(String summary, double longitude, double latitude) {
        this.summary = summary;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
