package com.henuajy.Servlet;

import com.henuajy.Model.LoginModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SendCommentServlet",value = "/SendCommentServlet")
public class SendCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String commentAccount=request.getParameter("commentAccount");
        String articalAccount=request.getParameter("articalAccount");
        String comment = request.getParameter("comment");
        int articalId = Integer.parseInt(request.getParameter("articalId"));
        boolean res = LoginModel.insertComment(commentAccount,articalAccount,comment,articalId);
        PrintWriter writer = response.getWriter();
        writer.print(res);
    }
}
