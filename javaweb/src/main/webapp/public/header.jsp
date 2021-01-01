<%--
  Created by IntelliJ IDEA.
  User: hhyygg2009
  Date: 2020/12/20
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String upload = request.getContextPath() + "/uploads";
    String root = request.getContextPath();
%>


<link rel="stylesheet" href="<%=request.getContextPath() %>/static/layui/css/layui.css">
<script src="<%=request.getContextPath() %>/static/layui/layui.js"></script>
<script src="<%=request.getContextPath() %>/static/js/jquery-3.4.1.min.js"></script>
<script>
    webroot = "<%=root%>";
    upload = "<%=upload%>";
</script>
<style>
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
    <ul class="layui-nav layui-layout-left  layui-bg-red" lay-filter="">
        <img class="logo" src="<%=request.getContextPath()%>/static/img/logo.png" alt="">
        <li class="layui-nav-item layui-this"><a href="<%=request.getContextPath() %>/trade/search.jsp">首页</a></li>
        <!--        <li class="layui-nav-item"><a href="{:url('Trade/search')}">手机二手</a></li>-->
        <!--        <li class="layui-nav-item"><a href="">书籍二手</a></li>-->
        <li class="layui-nav-item"><a href="<%=request.getContextPath() %>/trade/release">发布闲置</a></li>
        <li class="layui-nav-item"><a href="<%=request.getContextPath() %>/trade/my">我的闲置</a></li>
        <!--        <li class="layui-nav-item"><input type="text" class="layui-input" style="width: 100px" placeholder="搜索"></li>-->
        <!--        <li class="layui-nav-item"><button class="layui-btn layui-bg-red" style="border: 1px solid #FFF;">   search</button></li>-->
    </ul>


    <ul class="layui-nav layui-layout-right layui-bg-red ">
        <li class="layui-nav-item">
            <%--            <a href="<%=request.getContextPath() %>/trade/release">发布新闲置</a>--%>
            <!--            <a href="{:url('Trade/release')}">发布新闲置<span class="layui-badge">9</span></a>-->
        </li>
        <li class="layui-nav-item">
            <a href="<%=request.getContextPath() %>/passport/myprofile">我的账户<span class="layui-badge-dot"></span></a>
        </li>
        <li class="layui-nav-item">
            <a href=""><img src="<%=request.getContextPath()%>/uploads/default.png" class="layui-nav-img">我</a>
            <dl class="layui-nav-child">
                <dd><a href="<%=request.getContextPath() %>/passport/myprofile">修改个人信息</a></dd>
                <%--                <dd><a href="">安全管理</a></dd>--%>
                <dd><a href="<%=request.getContextPath() %>/passport/logout">退出</a></dd>
            </dl>
        </li>
    </ul>
</div>


<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function () {
        var element = layui.element;

        //…
    });
</script>