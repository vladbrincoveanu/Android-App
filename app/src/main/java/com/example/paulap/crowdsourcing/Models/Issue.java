package com.example.paulap.crowdsourcing.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Issue implements Serializable {
    private String title;
    private String description;
    private String solution;
    private String category; // paote fi ENUM sa nu avem mai mult de 3 tipuri predefinite de issues
    private int votes;
    private int imgRes;

    public Issue(String title, String description, String solution, String category,int votes,int imgRes) {
        this.title = title;
        this.description = description;
        this.solution = solution;
        this.category = category;
        this.votes = votes;
        this.imgRes = imgRes;
    }
    public Issue(){

    }


    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
