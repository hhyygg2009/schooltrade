<%--
  Created by IntelliJ IDEA.
  User: hhyygg2009
  Date: 2020/12/21
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>二手平台</title>

    <script src="<%=request.getContextPath() %>/static/layui/layui.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/static/layui/css/layui.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/itemdetail.css">


</head>


<body layadmin-themealias="default" class="layui-layout-body">
<div class="layui-layout ">

    <%--    {include file="public/header" /}--%>
    <%@ include file="/public/header.jsp" %>
    <!--    {include file="public/nav" /}-->
    <div class="layui-main" style="">
        <div class="layui-container">

            <div>
                <h3>${item.name}</h3>
                <p>${item.createtime}更新</p>

            </div>

            <div class="layui-row">
                <div class="layui-col-md3">
                    <div class="layui-carousel" id="carousel">
                        <div carousel-item>
                            <c:if test="${not empty item.pic1}">
                                <div><img src="<%=upload%>/${item.pic1}" alt=""></div>
                            </c:if>
                            <c:if test="${not empty item.pic2}">
                                <div><img src="<%=upload%>/${item.pic2}" alt=""></div>
                            </c:if>
                            <c:if test="${not empty item.pic3}">
                                <div><img src="<%=upload%>/${item.pic3}" alt=""></div>
                            </c:if>

                        </div>
                    </div>
                </div>

                <div class="layui-col-md6">
                    <table class="iteminfo">
                        <tr>
                            <td>价格</td>
                            <td>${item.price}￥</td>
                        </tr>
                        <tr>
                            <td>成色</td>
                            <td>${item.conditions.name}</td>
                        </tr>
                        <tr>
                            <td>联系人</td>
                            <td>${item.user.username}</td>
                        </tr>
                        <tr>
                            <td>联系电话</td>
                            <td>${item.user.phone}</td>
                        </tr>
                    </table>
                </div>

                <div class="layui-col-md3">
                    <table class="layui-table">
                        <tr>
                            <td></td>
                            <td><img src="<%=upload%>/${item.user.avatar}" alt=""></td>
                        </tr>
                        <tr>
                            <td>注册时间</td>
                            <td>${item.user.regtime}</td>
                        </tr>
                        <tr>
                            <td>昵称</td>
                            <td>${item.user.username}</td>
                        </tr>
                        <tr>
                            <td>手机</td>
                            <td>${item.user.phone}</td>
                        </tr>

                    </table>
                </div>

            </div>
            <div class="layui-row">
                <div class="layui-tab">
                    <ul class="layui-tab-title">
                        <li class="layui-this">详细介绍</li>
                        <!--                <li>相关推荐</li>-->
                    </ul>
                    <div class="layui-tab-content">
                        <div class="layui-tab-item layui-show">
                            <h1>文字介绍</h1>
                            <div>${item.info}</div>
                        </div>
                        <div class="layui-tab-item">
                            相关推荐
                        </div>
                    </div>
                </div>


            </div>


            <div class="layui-row">
                <h1>图片展示</h1>
                <div class="imgbox">
                    <c:if test="${not empty item.pic1}">
                        <div><img src="<%=upload%>/${item.pic1}" alt=""></div>
                    </c:if>
                    <c:if test="${not empty item.pic2}">
                        <div><img src="<%=upload%>/${item.pic2}" alt=""></div>
                    </c:if>
                    <c:if test="${not empty item.pic3}">
                        <div><img src="<%=upload%>/${item.pic3}" alt=""></div>
                    </c:if>
                </div>

            </div>

            <div>
                <h1>留言板</h1>
                <textarea class="layui-textarea"></textarea>
                <input type="submit" class="layui-btn">

            </div>

            <div class="layui-row">
                <div id="messagebroad" style="margin-top: 50px;">

                </div>
            </div>


        </div>
        <!--    {include file="public/footer" /}-->
        <%--    <%@ include file="/public/footer.jsp" %>--%>

    </div>


</body>
<script>
    var avatar =
    ${item.user.avatar}
    var username =${item.user.username};
</script>
<script src="<%=request.getContextPath()%>/static/js/trade/detail.js"></script>
</html>




