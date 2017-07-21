<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="resource/login/js/jquery.min.js"></script>
    <script src="resource/login/js/log.js"></script>
    <link rel="stylesheet" href="resource/login/css/normalize.css">
    <link rel="stylesheet" href="resource/login/css/myreset.css">
    <link rel="stylesheet" type="text/css" href="resource/login/css/login.css">
    <title>登陆</title>
</head>

<body>
<form action="CheckLoginServlet" method="post">
    <div id="container-login" class="container">
        <div id="content-login" class="content">
            <div class="header">
                <div id="logo">
                    <font class="logoword" color="dodgerblue">B</font>
                    <font class="logoword" color="orangered">o</font>
                    <font class="logoword" color="yellow">B</font>
                    <font class="logoword" color="lightgreen">o</font>
                    <font class="logoword" color="dodgerblue">S</font>
                    <font class="logoword" color="orangered">i</font>
                </div>
                <div id="title">登录</div>
                <div id="head-text">继续使用BoBoSi</div>
            </div>
            <div id="message">
            ${loginMessage }
            <c:remove var="loginMessage"/>
            </div>
            <div class="inputtext-box">
                <div class="inputtext" id="inputtext-name">
                    <input type="text" id="email" name="email" class="input-text" value="">
                    <div class="underline" id="underline-user"></div>
                    <label for="" class="lbl-boxmark" id="lbl-user">电子邮件地址</label>
                </div>
            </div>
            <div class="inputtext-box">
                <div class="inputtext" id="inputtext-pass">
                    <input type="password" id="pass" name="pass" class="input-text">
                    <div class="underline" id="underline-pass"></div>
                    <label for="" class="lbl-boxmark" id="lbl-pass">输入您的密码</label>
                </div>
            </div>
            <div class="loginbox">
                <div id="more-list">
                    <input type="Submit" onclick="return false;" id="more" value="更多选项">
                    <div class="otheroption" id="otheroption-list">
                        <span class="option" id="option">忘记了电子邮件地址？</span>
                        <a href="register.jsp"><span class="option" id="option2">创建账号</span></a>
                        <span class="option" id="option3">常见问题解答</span>
                    </div>
                </div>
                <input type="submit" id="btnlogin" onclick="return checkLogin()" value="下一步">
            </div>
        </div>
     </div>
     </form>
</body>

</body>
</html>