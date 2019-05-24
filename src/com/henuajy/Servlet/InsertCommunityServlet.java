package com.henuajy.Servlet;

import com.henuajy.Entity.CommunicateItem;
import com.henuajy.Entity.DiscoverItem;
import com.henuajy.Model.LoginModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InsertCommunityServlet",value = "/InsertCommunityServlet")
public class InsertCommunityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int defCode = Integer.parseInt(request.getParameter("def"));
        String userAccount = request.getParameter("userAccount");
        String title = request.getParameter("title");
        String headerPath = LoginModel.queryByUserAccount(userAccount,"headImgPath","userinfo");
        String uname = LoginModel.queryByUserAccount(userAccount,"uname","userinfo");
        int ulevel = Integer.parseInt(LoginModel.queryByUserAccount(userAccount,"level","userinfo"));
        String content = request.getParameter("content");
        String content_imgPath = request.getParameter("content_imgPath");
        String artical_cate = request.getParameter("artical_cate");
        String artical_time = request.getParameter("artical_time");
        int comment_count = Integer.parseInt(request.getParameter("comment_count"));
        int like_count = Integer.parseInt(request.getParameter("like_count"));

        CommunicateItem communicateItem = new CommunicateItem(headerPath,uname,ulevel,title,content,content_imgPath,artical_cate,artical_time,comment_count,like_count,defCode,userAccount);
        boolean res = LoginModel.InsertCommunityList(communicateItem);
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(res);
    }
}
