package com.zoray.savori.data;

public class SearchResult {

    private String name;
    private boolean bought;

    public void setName(String name) {
        this.name = name;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public String getName() {

        return name;
    }

    public boolean isBought() {
        return bought;
    }

    public SearchResult(String name, boolean bought) {

        this.name = name;
        this.bought = bought;
    }
}