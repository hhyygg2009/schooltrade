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

    <script src="/static/layui/layui.js"></script>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <link rel="stylesheet" href="/static/css/itemdetail.css">


</head>


<body class="layui-layout-body">
<div class="layui-layout ">

    <%--    {include file="public/header" /}--%>
    <%@ include file="/WEB-INF/jsp/public/header.jsp" %>
    <!--    {include file="public/nav" /}-->
    <div class="layui-main" style="">
        <div class="layui-container">

            <div>
                <h1>${item.name}</h1>
                <h3>0次浏览</h3>
                <p>${item.createtime}更新</p>

            </div>

            <div class="layui-row">
                <div class="layui-col-md3">
                    <div class="layui-carousel" id="carousel">
                        <div carousel-item>
                            <c:if test="${not empty item.pic1}">
                                <div><img src="/uploads/${item.pic1}" alt=""></div>
                            </c:if>
                            <c:if test="${not empty item.pic2}">
                                <div><img src="/uploads/${item.pic2}" alt=""></div>
                            </c:if>
                            <c:if test="${not empty item.pic3}">
                                <div><img src="/uploads/${item.pic3}" alt=""></div>
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
                            <td>${item.condition.name}</td>
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

<%--                    <div class="iteminfo-contact">联系卖家</div>--%>
<%--                    <div class="iteminfo-contact">我要购买</div>--%>
                </div>

                <div class="layui-col-md3">
                    <div class="user">

                        <img class="user-img" src="/uploads/${item.user.avatar}" alt="">
                        <div class="user-name">${item.user.username}</div>

                        <%--                        <tr>--%>
                        <%--                            <td>注册时间</td>--%>
                        <%--                            <td>${item.user.regtime}</td>--%>
                        <%--                        </tr>--%>
                        <%--                        <tr>--%>
                        <%--                            <td>昵称</td>--%>
                        <%--                            <td>${item.user.username}</td>--%>
                        <%--                        </tr>--%>
                        <%--                        <tr>--%>
                        <%--                            <td>手机</td>--%>
                        <%--                            <td>${item.user.phone}</td>--%>
                        <%--                        </tr>--%>

                        <div><span>他的交易</span><a href="/user/${item.user.id}">查看详细信息></a></div>
                        <div class="user-selling">
                            <div class="user-selling-num">17</div>
                            <div class="user-selling-num-text">在售宝贝</div>
                        </div>
                        <div class="user-selling">
                            <div class="user-selling-num">17</div>
                            <div class="user-selling-num-text">在售宝贝</div>
                        </div>
                        <div class="user-selling">
                            <div class="user-selling-num">17</div>
                            <div class="user-selling-num-text">在售宝贝</div>
                        </div>
                    </div>
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
                            <div class="shop-detail">
                                <img class="user-img" src="/uploads/${item.user.avatar}" alt="">
                                <div class="user-name">${item.user.username}</div>
                                有话说
                                <div>${item.info}</div>
                            </div>
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
                        <div><img src="/uploads/${item.pic1}" alt=""></div>
                    </c:if>
                    <c:if test="${not empty item.pic2}">
                        <div><img src="/uploads/${item.pic2}" alt=""></div>
                    </c:if>
                    <c:if test="${not empty item.pic3}">
                        <div><img src="/uploads/${item.pic3}" alt=""></div>
                    </c:if>
                </div>

            </div>

<%--            <div>--%>
<%--                <h1>留言板</h1>--%>
<%--                <textarea class="layui-textarea"></textarea>--%>
<%--                <input type="submit" class="layui-btn">--%>

<%--            </div>--%>

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
    var avatar = '${item.user.avatar}'

    var username = '${item.user.username}';
</script>
<script src="/static/js/trade/detail.js"></script>
</html>




