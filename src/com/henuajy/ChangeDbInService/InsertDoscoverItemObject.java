package com.henuajy.ChangeDbInService;

import com.henuajy.Entity.DiscoverItem;
import com.henuajy.Model.LoginModel;

import java.util.Scanner;

public class InsertDoscoverItemObject {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("==========发现页数据库录入============");
        System.out.println(System.currentTimeMillis());
        int def;
        String title;
        String author;
        String picturePath;
        while(true){
            System.out.print("标记：");
            def = Integer.parseInt(input.nextLine());
            System.out.print("标题：");
            title = input.nextLine();
            System.out.print("作者：");
            author = input.nextLine();
            System.out.print("图片路径：");
            picturePath = input.nextLine();
            DiscoverItem item = new DiscoverItem(def,title,author,picturePath);
            boolean res = LoginModel.InsertDiscoverItem(item);
            if (res){
                System.out.println("插入成功！");
            }


        }
    }

}
