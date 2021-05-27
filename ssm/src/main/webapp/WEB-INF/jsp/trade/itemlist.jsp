<%--
  Created by IntelliJ IDEA.
  User: hhyygg2009
  Date: 2020/12/21
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--<link rel="stylesheet" href="/static/css/user.css">--%>
<%--<link rel="stylesheet" href="/static/css/header.css">--%>
<%--<link rel="stylesheet" href="/static/css/zhanghu.css">--%>
<%--<link rel="stylesheet" href="/static/css/goods-info.css">--%>
<link rel="stylesheet" href="/static/css/my.css">


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>二手平台</title>
</head>


<body layadmin-themealias="default" class="layui-layout-body">
<div class="layui-layout ">
    <%@ include file="/WEB-INF/jsp/public/header.jsp" %>
    <div class="layui-main" style="">
        <div class="layui-row">
            <div class="left-side-zu">
                <a href=""><img src="/uploads/${user.avatar}" class="left-side-img" alt=""></a>
                <div class="user-info">
                    <a href="" class="user-name" onclick="">${user.username}</a>
                    <a href="">消息(<span id="msg"><pp>0</pp></span>)</a>
                </div>
                <br>
                <br>
                <div class="user-link">
                    <div class="user-limit-p">
                        <a href="" onclick="">
                            <span class="user-limit-img"></span>
                            <span class="user-limit-mb">${user.phone}</span></a>
                    </div>
                    <div class="user-limit-d">
                        <a href="" onclick=""><span class="user-limit-email"></span></a>
                    </div>
                    <div class="user-limit-w">
                        <a href="" onclick=""><span class="user-limit-weixin"></span></a>
                    </div>
                    <div class="user-limit-q">
                        <a href="" onclick=""><span class="user-limit-qq"></span></a>
                    </div>
                    <div class="user-limit-b">
                        <a href="" onclick=""><span class="user-limit-weibo"></span></a>
                    </div>
                </div>


            </div>

        </div>

        <div class="layui-row">
            <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                <ul class="layui-tab-title">
                    <li class="layui-this">最近发布信息</li>
                    <li>我浏览过的信息</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <div id="items">
                            <!--JS插入数据-->
                        </div>

                        <div class="layui-row">
                            <div id="pager"></div>
                        </div>
                    </div>
                    <div class="layui-tab-item"></div>
                </div>
            </div>
        </div>

        <script>
            layui.use('element', function () {
                var element = layui.element;
                element.on('nav(demo)', function (elem) {
                    //console.log(elem)
                    layer.msg(elem.text());
                });
            });
        </script>


        <script>

            var userid =${userid}
        </script>


        <script src="/static/js/util.js"></script>
        <script src="/static/js/trade/itemlist.js"></script>


    </div>


</div>


</body>

</html>
