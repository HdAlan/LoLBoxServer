package com.henuajy.Entity;

public class DiscoverItem {
    private int def;
    private String title;
    private String author;
    private String picturePath;
    public DiscoverItem(int def,String title, String author,String picturePath){
        this.def = def;
        this.title = title;
        this.author = author;
        this.picturePath = picturePath;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
}
