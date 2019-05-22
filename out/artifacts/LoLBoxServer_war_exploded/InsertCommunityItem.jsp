<%--
  Created by IntelliJ IDEA.
  User: HenuAJY
  Date: 2019/5/19
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加社交页数据</title>
</head>
<body>
标记为文章类别可填1或2或3，1代表“全部”，2代表“视频”，3代表“精华”
<form action="InsertCommunityServlet" method="post">
    标记：<input type="text" name="def"><br>
    用户头像：<input type="text" name="headerPath"><br>
    用户名：<input type="text" name="uname"><br>
    用户等级：<input type="text" name="ulevel"><br>
    文章标题<input type="text" name="title"><br>
    文章部分内容：<input type="text" name="content"><br>
    文章图片：<input type="text" name="content_imgPath"><br>
    文章分类：<input type="text" name="artical_cate"><br>
    文章时间：<input type="text" name="artical_time"><br>
    评论数：<input type="text" name="comment_count"><br>
    点赞数：<input type="text" name="like_count"><br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
