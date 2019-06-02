package com.henuajy.Entity;

public class User {

    private String account;
    private String password;
    private String headImgPath;
    private String uname;
    private int level;
    public User(String account,String password){
        this.account = account;
        this.password = password;
    }

    public User(String account,String headImgPath,String uname,int level){
        this.account=account;
        this.headImgPath = headImgPath;
        this.uname = uname;
        this.level = level;
    }



    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadImgPath() {
        return headImgPath;
    }

    public void setHeadImgPath(String headImgPath) {
        this.headImgPath = headImgPath;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
