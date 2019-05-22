<%--
  Created by IntelliJ IDEA.
  User: HenuAJY
  Date: 2019/5/19
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>向数据库录入发现页数据</title>
</head>
<body>
标记为1代表“推荐”，标记为0代表“赛事”
<form action="InsertDiscoverItemServlet" method="post">
    标记：<input type="text" name="defCode"><br>
    标题：<input type="text" name="title"><br>
    作者：<input type="text" name="author"><br>
    图片路径：<input type="text" name="picturePath"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
