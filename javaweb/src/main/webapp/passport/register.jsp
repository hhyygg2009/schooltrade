<%--
  Created by IntelliJ IDEA.
  User: hhyygg2009
  Date: 2020/12/20
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户注册</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/register.css">

</head>

<body>
<%@ include file="/public/header.jsp" %>
<!--<div class="top-png">-->
<!--    <img src="img/top.png" alt="">-->
<!--</div>-->
<div class="top-title"><span>注册</span></div>
<div class="main">

    <form class="layui-form" action="#" method="post">
        <!--  <div class="layui-form-item">-->
        <!--    <label class="layui-form-label">帐号</label>-->
        <!--    <div class="layui-input-block">-->
        <!--      <p class="input-box"><input type="text" name="number" required  lay-verify="number" placeholder="请输入登录" autocomplete="off" class="layui-input"></p>-->
        <!--    </div>-->
        <!--  </div>-->

        <div class="layui-form-item">
            <label class="layui-form-label">昵称</label>
            <div class="layui-input-block">
                <p class="input-box"><input type="text" name="username" lay-verify="name" required placeholder="请输入昵称"
                                            autocomplete="off" class="layui-input">
                </p>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" required lay-verify="pass" placeholder="请输入密码" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">密码必须6到12位</div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">选择院系</label>
            <div class="layui-input-block">
                <select name="family" lay-verify="required">
                    <option value=""></option>
                    <option value="0">计算机系</option>
                    <option value="1">软件工程系</option>
                    <option value="2">网络技术系</option>
                    <option value="3">数码媒体系</option>
                    <option value="4">游戏系</option>
                    <option value="5">管理系</option>
                    <option value="6">国际经贸系</option>
                    <option value="7">财会系</option>
                    <option value="8">外语系</option>
                    <option value="9">电子系</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">单选框</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="0" title="男">
                <input type="radio" name="sex" value="1" title="女" checked>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">手机号码</label>
            <div class="layui-input-block">
                <p class="input-box"><input type="text" name="phone" required lay-verify="required|phone"
                                            placeholder="请输入手机号码" autocomplete="off" class="layui-input"></p>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">验证码</label>
            <div class="layui-input-block">
                <p class="input-box">
                <p class="code-box"><input type="text" name="captcha" required lay-verify="required"
                                           placeholder="请输入验证码"
                                           autocomplete="off" class="layui-input"></p>
                <!--                <button type="button" class="layui-btn">点击获取</button>-->
                <img id="code" onclick="reloadcode()" src="<%=request.getContextPath()%>/passport/code.jsp" alt="">
                </p>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="register">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>

<script src="<%=request.getContextPath()%>/static/js/passport/register.js"></script>

</html>
