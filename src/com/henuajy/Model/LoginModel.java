package com.henuajy.Model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.henuajy.Entity.CommunicateItem;
import com.henuajy.Entity.DiscoverItem;
import com.henuajy.Entity.User;
import com.mysql.cj.xdevapi.JsonArray;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginModel {
    private static String DBUNAME = "root";
    private static String DBUPWD = "121181";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/lolbox?&serverTimezone=UTC&useSSL=false";

    public static boolean login(User user){
        String loginAccount = user.getLoginAccount();
        String loginPassword = user.getLoginPassword();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
            pstmt = con.prepareStatement("select count(*)from userinfo where account=? and password=?");
            pstmt.setString(1,loginAccount);
            pstmt.setString(2,loginPassword);
            rs = pstmt.executeQuery();
            if (rs.next()){
                count = rs.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if (rs!=null){
                    rs.close();
                }
                if (pstmt!=null){
                    pstmt.close();
                }
                if (con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (count==1){
                return true;
            }else{
                return false;
            }
        }
    }

    public static boolean register(User user){
        String loginAccount = user.getLoginAccount();
        String loginPassword = user.getLoginPassword();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
            pstmt = con.prepareStatement("insert into userinfo values (?,?)");
            pstmt.setString(1,loginAccount);
            pstmt.setString(2,loginPassword);
            count = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if (rs!=null){
                    rs.close();
                }
                if (pstmt!=null){
                    pstmt.close();
                }
                if (con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (count==1){
                return true;
            }else{
                return false;
            }
        }
    }

    public static JSONArray queryDiscoverItemList(String defCode){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        JSONArray jsonValues = new JSONArray();
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
            pstmt = con.prepareStatement("select*From discoverlist where def=?");
            pstmt.setString(1,defCode);
            rs = pstmt.executeQuery();
            while (rs.next()){
                int def = rs.getInt("def");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String picturePath = rs.getString("picturePath");
                jsonValues.add(new DiscoverItem(def,title,author,picturePath));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if (rs!=null){
                    rs.close();
                }
                if (pstmt!=null){
                    pstmt.close();
                }
                if (con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return jsonValues;
    }

    public static boolean InsertDiscoverItem(DiscoverItem discoverItem){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
            pstmt = con.prepareStatement("insert into discoverlist(def,title,author,picturePath) values (?,?,?,?)");
            pstmt.setInt(1,discoverItem.getDef());
            pstmt.setString(2,discoverItem.getTitle());
            pstmt.setString(3,discoverItem.getAuthor());
            pstmt.setString(4,discoverItem.getPicturePath());
            count = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if (rs!=null){
                    rs.close();
                }
                if (pstmt!=null){
                    pstmt.close();
                }
                if (con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (count==1){
                return true;
            }else{
                return false;
            }
        }
    }

    public static JSONArray queryCommunityItemList(String defCode){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        JSONArray jsonValues = new JSONArray();
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
            pstmt = con.prepareStatement("select*From communitylist where def=?");
            pstmt.setString(1,defCode);
            rs = pstmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int def = rs.getInt("def");
                String head_icoPath = rs.getString("head_icoPath");
                String userName = rs.getString("userName");
                int level = rs.getInt("level");
                String title = rs.getString("title");
                String summary = rs.getString("summary");
                String articalImgPath = rs.getString("articalImgPath");
                String articalCate = rs.getString("articalCate");
                String articalTime = rs.getString("articalTime");
                int articalCommCounts = rs.getInt("articalCommcounts");
                int articalLikeCounts = rs.getInt("articalLikeCounts");
                jsonValues.add(new CommunicateItem(head_icoPath,userName,level,title,summary,articalImgPath
                                ,articalCate,articalTime,articalCommCounts,articalLikeCounts,def));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if (rs!=null){
                    rs.close();
                }
                if (pstmt!=null){
                    pstmt.close();
                }
                if (con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return jsonValues;
    }

    public static boolean InsertCommunityList(CommunicateItem communicateItem){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
            pstmt = con.prepareStatement("insert into communitylist(head_icoPath,userName,level,title,summary,articalImgPath,articalCate,articalTime,articalCommcounts,articalLikeCounts,def) values (?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1,communicateItem.getHead_icoPath());
            pstmt.setString(2,communicateItem.getUserName());
            pstmt.setInt(3,communicateItem.getLevel());
            pstmt.setString(4,communicateItem.getTitle());
            pstmt.setString(5,communicateItem.getSummary());
            pstmt.setString(6,communicateItem.getArticalImgPath());
            pstmt.setString(7,communicateItem.getArticalCate());
            pstmt.setString(8,communicateItem.getArticalTime());
            pstmt.setInt(9,communicateItem.getArticalCommCounts());
            pstmt.setInt(10,communicateItem.getArticalLikeCounts());
            pstmt.setInt(11,communicateItem.getDef());
            count = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if (rs!=null){
                    rs.close();
                }
                if (pstmt!=null){
                    pstmt.close();
                }
                if (con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (count==1){
                return true;
            }else{
                return false;
            }
        }
    }
}
