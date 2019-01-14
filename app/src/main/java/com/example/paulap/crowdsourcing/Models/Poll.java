package com.example.paulap.crowdsourcing.Models;

public class Poll {

    private String title;
    private String desription;
    private String category1;
    private String category2;
    private String category3;

    public Poll(String title, String desription, String category1, String category2, String category3) {
        this.title = title;
        this.desription = desription;
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }
}

