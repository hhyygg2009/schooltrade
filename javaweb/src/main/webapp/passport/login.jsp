<%--
  Created by IntelliJ IDEA.
  User: hhyygg2009
  Date: 2020/12/20
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户登录</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/register.css">
</head>

<body>
<%@ include file="/public/header.jsp" %>
<div class="top-title"><span>登录</span></div>
<div class="main">

    <form class="layui-form" action="#" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">帐号</label>
            <div class="layui-input-block">
                <p class="input-box"><input type="text" name="username" required lay-verify="required"
                                            placeholder="请输入登录"
                                            autocomplete="off" class="layui-input"></p>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <p class="Login-password"><input type="password" name="password" required lay-verify="required"
                                                 placeholder="请输入密码" autocomplete="off" class="layui-input"></p>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">验证码</label>
            <div class="layui-input-block">
                <p class="input-box">
                <p class="code-box"><input type="text" name="captcha" required lay-verify="required"
                                           placeholder="请输入验证码"
                                           autocomplete="off" class="layui-input"></p>
                <div>
                    <img id="code" onclick="reloadcode()" src="<%=request.getContextPath()%>/passport/code.jsp" alt="">
                </div>
                </p>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="login">登录</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                <a href="register.jsp" class="layui-btn">注册</a>
            </div>
        </div>
    </form>
</div>
</body>


<script src="<%=request.getContextPath()%>/static/js/passport/login.js"></script>
</html>
