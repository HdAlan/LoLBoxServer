package com.henuajy.Servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.henuajy.Entity.User;
import com.henuajy.Model.LoginModel;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet",value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String registerAccount = request.getParameter("registerAccount");
        String registerPassword = request.getParameter("registerPassword");
        User registerUser = new User(registerAccount,registerPassword);
        boolean rs = LoginModel.register(registerUser);
        System.out.println("注册账号："+registerAccount+",注册密码："+registerPassword+",注册结果"+rs);
        //通过PrintWriter返回给客户端操作结果
        PrintWriter writer = response.getWriter();
        writer.print(rs);
    }
}
