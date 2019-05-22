package com.henuajy.Servlet;

import com.alibaba.fastjson.JSONArray;
import com.henuajy.Model.LoginModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetDiscoverRecommentListServlet",value = "/GetDiscoverRecommentListServlet")
public class GetDiscoverRecommentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String defCode = request.getParameter("defCode");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        JSONArray jsonArray = LoginModel.queryDiscoverItemList(defCode);
        //System.out.println(jsonArray.toJSONString());
        writer.println(jsonArray.toJSONString());
    }
}