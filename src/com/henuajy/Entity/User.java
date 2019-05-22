package com.henuajy.Entity;

public class User {
    private String loginAccount;
    private String loginPassword;

    public User(String loginAccount,String loginPassword){
        this.loginAccount = loginAccount;
        this.loginPassword = loginPassword;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
