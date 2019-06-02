package com.henuajy.Servlet;

import com.alibaba.fastjson.JSONObject;
import com.henuajy.Model.LoginModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetUserInfoServlet",value = "/GetUserInfoServlet")
public class GetUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String account = request.getParameter("account");
        JSONObject user = LoginModel.queryUserInfo(account);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer =response.getWriter();
        writer.print(user);
        System.out.print("getUserInfo：account="+account);
    }
}
