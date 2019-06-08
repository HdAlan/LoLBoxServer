package com.henuajy.Debug;

import com.henuajy.Model.LoginModel;

public class TestDB {
    public static void main(String[] args){
        String data = LoginModel.queryByUserAccount("1211","birthday","userinfo");
        System.out.println(data);
    }
}
