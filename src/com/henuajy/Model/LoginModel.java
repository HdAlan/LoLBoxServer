package com.henuajy.Model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.henuajy.Entity.CommunicateItem;
import com.henuajy.Entity.DiscoverItem;
import com.henuajy.Entity.FitghtScore;
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

    /**
     * 执行登录操作
     * @param user  用户实例
     * @return 登录结果
     */
    public static boolean login(User user){
        String loginAccount = user.getAccount();
        String loginPassword = user.getPassword();
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

    /**
     * 执行注册操作
     * @param user 用户实例
     * @return 返回注册结果
     */
    public static boolean register(User user){
        String loginAccount = user.getAccount();
        String loginPassword = user.getPassword();
        String uname = user.getUname();
        String email = user.getEmail();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
            pstmt = con.prepareStatement("insert into userinfo (account,password,uname,email) values (?,?,?,?)");
            pstmt.setString(1,loginAccount);
            pstmt.setString(2,loginPassword);
            pstmt.setString(3,uname);
            pstmt.setString(4,email);
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

    /**
     * 查询发现页列表项
     * @param defCode  鉴别码
     * @return  返回查询结果
     */
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

    /**
     * 根据账号查询用户信息
     * @param a 账号
     * @return 返回一个包含部分用户信息的JSONObject
     */
    public static JSONObject queryUserInfo(String a){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        JSONObject jsonObject = new JSONObject();
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
            pstmt = con.prepareStatement("select*From userinfo where account=?");
            pstmt.setString(1,a);
            rs = pstmt.executeQuery();
            if (rs.next()){
                String account = rs.getString("account");
                String password = rs.getString("password");
                String headImgPath=rs.getString("headImgPath");
                String uname=rs.getString("uname");
                int level=rs.getInt("level");
                int focus=rs.getInt("focus");
                int fans=rs.getInt("fans");
                int thumbs=rs.getInt("thumbsup");
                String email = rs.getString("email");
                jsonObject.put("account",account);
                jsonObject.put("password",password);
                jsonObject.put("headImgPath",headImgPath);
                jsonObject.put("uname",uname);
                jsonObject.put("level",level);
                jsonObject.put("focus",focus);
                jsonObject.put("fans",fans);
                jsonObject.put("thumbs",thumbs);
                jsonObject.put("email",email);
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
        return jsonObject;
    }

    /**
     * 向数据库插入发现页新闻
     * @param discoverItem 新闻实例
     * @return 返回操作结果
     */
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

    /**
     * 查询社交页文章列表
     * @param defCode   鉴别码
     * @return 返回一个包含多个列表项的JSONArray
     */
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
                String userAccount = rs.getString("userAccount");
                jsonValues.add(new CommunicateItem(id,head_icoPath,userName,level,title,summary,articalImgPath
                                ,articalCate,articalTime,articalCommCounts,articalLikeCounts,def,userAccount));
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

    /**
     * 发布文章
     * @param communicateItem 文章实例
     * @return 操作结果
     */
    public static boolean InsertCommunityList(CommunicateItem communicateItem){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
            pstmt = con.prepareStatement("insert into communitylist(head_icoPath,userName,level,title,summary,articalImgPath,articalCate,articalTime,articalCommcounts,articalLikeCounts,def,userAccount) values (?,?,?,?,?,?,?,?,?,?,?,?)");
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
            pstmt.setString(12,communicateItem.getUserAccount());
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

    /**
     * 功能暂不明确
     * @param userAccount
     * @param columnIndex
     * @param tableName
     * @return
     */
    public static String queryByUserAccount(String userAccount,String columnIndex,String tableName){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String beingReturnedRes = null;
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
            pstmt = con.prepareStatement("select "+columnIndex+" from "+tableName+" where account = ?");
            pstmt.setString(1,userAccount);
            rs = pstmt.executeQuery();
            if (rs.next()){
                beingReturnedRes = rs.getString(columnIndex);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null){
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
            return beingReturnedRes;
        }
    }

    /**
     * 获取用户战绩列表
     * @param account
     * @return
     */
    public static JSONArray queryUserScoreList(String account){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        JSONArray jsonArray = new JSONArray();
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
            pstmt = con.prepareStatement("select*from scorelist where account=?");
            pstmt.setString(1,account);
            rs = pstmt.executeQuery();
            while (rs.next()){
                String picPath = rs.getString("heroPicPath");
                String fightRes = rs.getString("fightRes");
                String category = rs.getString("category");
                String time = rs.getString("time");
                FitghtScore score = new FitghtScore(picPath,fightRes,category,time);
                jsonArray.add(score);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    /**
     * 获取单个文章的评论列表
     * @param aId 文章ID
     * @return
     */
    public static JSONArray queryComments(int aId){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        JSONArray jsonArray = new JSONArray();
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
            pstmt = con.prepareStatement("select a.headImgPath,a.uname,a.`level`,b.* from userinfo a,comments b where b.articalId = ? and a.account=b.commentAccount;");
            pstmt.setInt(1,aId);
            rs = pstmt.executeQuery();
            while (rs.next()){
                String headPath = rs.getString("headImgPath");
                String userName = rs.getString("uname");
                int level = rs.getInt("level");
                int commentId = rs.getInt("id");
                String commentAccount = rs.getString("commentAccount");
                String articalAccount = rs.getString("articalAccount");
                String comment = rs.getString("comment");
                int articalId = rs.getInt("id");
                jsonArray.add(new CommunicateItem(headPath,userName,level,commentId,commentAccount,articalAccount,comment,articalId));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    public static boolean insertComment(String commentAccount,String articalAccount,String comment,int articalId){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
            //取消外键约束
            pstmt = con.prepareStatement("SET foreign_key_checks=0;");
            pstmt.execute();
            //插入数据
            pstmt = con.prepareStatement("insert into comments (commentAccount,articalAccount,`comment`,articalId) values (?,?,?,?);");
            pstmt.setString(1,commentAccount);
            pstmt.setString(2,articalAccount);
            pstmt.setString(3,comment);
            pstmt.setInt(4,articalId);
            count = pstmt.executeUpdate();
            //恢复外键约束
            pstmt = con.prepareStatement("SET foreign_key_checks=1;");
            pstmt.execute();
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
