package com.example.paulap.crowdsourcing.Models;

public class Issue {
    private String summary;
    private String description;
    private String solution;
    private String category; // paote fi ENUM sa nu avem mai mult de 3 tipuri predefinite de issues

    public Issue(String summary, String description, String solution, String category) {
        this.summary = summary;
        this.description = description;
        this.solution = solution;
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
