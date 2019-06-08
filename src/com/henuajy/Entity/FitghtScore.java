package com.henuajy.Entity;

public class FitghtScore {
    private String heroPicPath;
    private String fightRes;
    private String category;
    private String time;
    public FitghtScore(String pic, String score, String category, String time){
        this.heroPicPath = pic;
        this.fightRes = score;
        this.category = category;
        this.time = time;
    }

    public String getHeroPicPath() {
        return heroPicPath;
    }

    public void setHeroPicPath(String heroPicPath) {
        this.heroPicPath = heroPicPath;
    }

    public String getFightRes() {
        return fightRes;
    }

    public void setFightRes(String fightRes) {
        this.fightRes = fightRes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
