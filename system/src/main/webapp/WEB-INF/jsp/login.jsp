<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/15
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录</title>
    <%@include file="/WEB-INF/jsp/util/base.jsp"%>
    <link type="text/css" rel="stylesheet" href="${ctx}/static/css/login.css"/>
</head>
<body>
    <div class="container">
        <div class="loginmain">
            <form id="form" method="post" action="${ctx}/sys/login">
            <p><span>后台管理系统</span></p>
            <p><span>账&nbsp;&nbsp;号：</span><input type="text" id="username" name="username"/></p>
            <p><span>密&nbsp;&nbsp;码：</span><input type="password" id="password" name="password"/></p>

            <p><input type="submit" value="登录"></p>
            </form>
            ${msg}
        </div>
    </div>
</body>
</html>
