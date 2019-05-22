package com.henuajy.Servlet;

import com.henuajy.Entity.DiscoverItem;
import com.henuajy.Model.LoginModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertDiscoverItemServlet",value = "/InsertDiscoverItemServlet")
public class InsertDiscoverItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String defCode = request.getParameter("defCode");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String picturePath = request.getParameter("picturePathm ");
        DiscoverItem discoverItem = new DiscoverItem(Integer.parseInt(defCode),title,author,picturePath);
        boolean res = LoginModel.InsertDiscoverItem(discoverItem);
        if (res){
            response.sendRedirect("success_insertDiscover.jsp");
        }else{
            response.sendRedirect("failed_insertDiscover.jsp");
        }
    }
}
