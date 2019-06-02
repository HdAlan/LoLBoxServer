package com.henuajy.Servlet;

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

//实现用户登录，若登录成功，返回用户信息
@WebServlet(name = "LoginServlet",value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String loginAccount = request.getParameter("loginAccount");
        String loginPassword = request.getParameter("loginPassword");
        User user = new User(loginAccount,loginPassword);
        boolean result = LoginModel.login(user);
        response.setCharacterEncoding("UTF-8");
        //通过PrintWriter返回给客户端操作结果
        PrintWriter writer = response.getWriter();
        if (result){
            JSONObject userObject = LoginModel.queryUserInfo(loginAccount);
            writer.print(userObject);
        }
        System.out.println("account:"+loginAccount+",password:"+loginPassword+",result:"+result);
    }
}
