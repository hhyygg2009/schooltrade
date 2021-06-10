<%--
  User: hhyygg2009
  Date: 2020/12/21
  Time: 12:20
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>二手平台</title>
</head>

<body layadmin-themealias="default" class="layui-layout-body">
<div class="layui-layout ">
    <%@ include file="/WEB-INF/jsp/public/header.jsp" %>
    <div class="layui-main">
        <div class="searchbar">
            <form method="get">
                <img id="logo" src="/static/img/logo.png" alt="">
                <input type="text" name="key" id="search" value="${key}" placeholder="搜   索" autocomplete="off"/>
                <input type="submit" id="searchbtn" value="搜         索" class="searchbtn"/>
            </form>
            <div id="layfilter" lay-filter="layfilter"></div>
            <button class="layui-btn layui-btn-primary" id="getvalBtn">获取选中值</button>
        </div>

        <div class="shelves layui-row" id="items">
            <!--插入物品-->
        </div>
        <div id="page" class="layui-row">
            <!--插入分页-->
        </div>
    </div>
</div>
</body>

<link rel="stylesheet" href="/static/css/search.css">
<script src="/static/js/trade/search.js"></script>

</html>

