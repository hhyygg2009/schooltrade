<%--
  Created by IntelliJ IDEA.
  User: hhyygg2009
  Date: 2020/12/21
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String key = request.getParameter("key");
    if (key != null) {
        key = ",'key':" + key;
    }
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>二手平台</title>
</head>


<body layadmin-themealias="default" class="layui-layout-body">
<div class="layui-layout ">
    <%@ include file="/public/header.jsp" %>
    <div class="layui-main" style="">
        <div class="searchbar">
            <form method="get" action="<%=request.getContextPath() %>/trade/search.jsp">
                <img id="logo" src="<%=request.getContextPath()%>/static/img/logo.png" alt="">
                <input type="text" name="key" id="search" value="" placeholder="搜   索" autocomplete="off"/>
                <input type="submit" id="searchbtn" value="搜         索" class="searchbtn"/>
            </form>
        </div>
        <div class="shelves layui-row" id="items"></div>
        <div id="page" class="layui-row"></div>
    </div>
</div>
</body>

<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/search.css">
<script>
    var keyword = "<%=request.getParameter("key")%>"
</script>
<script src="<%=request.getContextPath()%>/static/js/trade/search.js"></script>

</html>

