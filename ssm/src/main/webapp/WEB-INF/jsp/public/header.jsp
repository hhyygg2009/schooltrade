<%--
  Created by IntelliJ IDEA.
  User: hhyygg2009
  Date: 2020/12/20
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet" href="/static/layui/css/layui.css">
<script src="/static/layui/layui.js"></script>
<script src="/static/js/public/jquery-3.4.1.min.js"></script>
<script src="/static/js/public/header.js"></script>
<script src="/static/js/public/util.js"></script>


<style>
    * {
        margin: 0;
        padding: 0;
    }

    .layui-layout-body {
        overflow: auto;
    }

    .layui-header {
        margin-bottom: 30px;
    }

    .logo {
        height: 60px;
    }


</style>


<div class="layui-header layui-bg-red">
    <ul class="layui-nav layui-layout-left  layui-bg-red" >
        <img class="logo" src="/static/img/logo.png" alt="">
        <li class="layui-nav-item layui-this"><a href="/search">首页</a></li>
        <!--        <li class="layui-nav-item"><a href="{:url('Trade/search')}">手机二手</a></li>-->
        <!--        <li class="layui-nav-item"><a href="">书籍二手</a></li>-->
        <li class="layui-nav-item"><a href="/newitem">发布闲置</a></li>
        <li class="layui-nav-item"><a href="/my">我的闲置</a></li>
        <!--        <li class="layui-nav-item"><input type="text" class="layui-input" style="width: 100px" placeholder="搜索"></li>-->
        <!--        <li class="layui-nav-item"><button class="layui-btn layui-bg-red" style="border: 1px solid #FFF;">   search</button></li>-->
    </ul>


    <ul class="layui-nav layui-layout-right layui-bg-red ">
        <li class="layui-nav-item">
            <%--            <a href="/newitem">发布新闲置</a>--%>
            <!--            <a href="{:url('Trade/newitem')}">发布新闲置<span class="layui-badge">9</span></a>-->
        </li>
        <li class="layui-nav-item">
            <a href="/passport/profile">我的账户<span class="layui-badge-dot"></span></a>
        </li>
        <li class="layui-nav-item">
            <a href=""><img src="/uploads/default.png" class="layui-nav-img">我</a>
            <dl class="layui-nav-child">
                <dd><a href="/passport/profile">修改个人信息</a></dd>
                <%--                <dd><a href="">安全管理</a></dd>--%>
                <dd><a href="/passport/logout">退出</a></dd>
            </dl>
        </li>
    </ul>
</div>


