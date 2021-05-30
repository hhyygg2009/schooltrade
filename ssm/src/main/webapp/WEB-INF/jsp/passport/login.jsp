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
</head>

<body>
<%@ include file="/WEB-INF/jsp/public/header.jsp" %>
<div class="login-box">
    <div class="main">
        <div class="top-title"><span>登录</span></div>

        <form class="layui-form" action="#" method="post">
            <div class="layui-form-item">
                <label class="layui-form-label">帐号</label>
                <div class="layui-input-block">
                    <p class="input-box">
                        <input type="text" name="username" required lay-verify="required"
                               placeholder="请输入登录"
                               autocomplete="off" class="layui-input">
                    </p>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                    <p class="Login-password">
                        <input type="password" name="password" required lay-verify="required"
                               placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </p>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">验证码</label>
                <div class="layui-input-block">
                    <div class="input-box">
                        <div class="code-box">
                            <input type="text" name="captcha" required lay-verify="required"
                                   placeholder="请输入验证码"
                                   autocomplete="off" class="layui-input">
                        </div>
                        <img id="code" onclick="reloadCode()" src="/passport/code" alt="">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="login">登录</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    <a href="/passport/register" class="layui-btn">注册</a>
                    <p>登录即同意《58同城使用协议》&《隐私政策》</p>
                </div>
            </div>
        </form>
    </div>
</div>
</body>


<script src="/static/js/passport/login.js"></script>
<script src="/static/js/passport/code.js"></script>
<link rel="stylesheet" href="/static/css/login.css">

</html>
