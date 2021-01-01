<%--
  Created by IntelliJ IDEA.
  User: hhyygg2009
  Date: 2020/12/25
  Time: 9:37
  To change this template use File | Settings | File Templates.
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
    <%@ include file="/public/header.jsp" %>
    <div class="layui-main" style="">
        <h3>个人资料</h3>
        <div class="layui-row">
            <div class="layui-col-md9">
                <img id="headperview" src="<%=upload%>/${user.avatar}" alt="" style="height: 150px">
                <button class="layui-btn" id="test2">上传头像</button>
            </div>
        </div>

        <div class="layui-row">
            <div class="layui-col-md9">
                <h3>个人资料</h3>
                <table class="layui-table">
                    <tr>
                        <td>注册时间</td>
                        <td>${user.regtime}</td>
                    </tr>
                    <tr>
                        <td>昵称</td>
                        <td>${user.username}</td>
                    </tr>
                    <tr>
                        <td>手机</td>
                        <td>${user.phone}</td>
                    </tr>

                </table>
            </div>
        </div>


        <div class="layui-row">
            <div class="layui-col-md9">
                <h1>修改信息</h1>
                <fieldset class="layui-elem-field">
                    <legend>修改个人资料</legend>
                    <div class="layui-field-box">
                        <form action="" method="post" class="layui-form">
                            <input type="text" name="id" value="${user.id}" hidden>
                            <table class="layui-table">
                                <tr>
                                    <td>昵称</td>
                                    <td><input type="text" name="username" value="${user.username}" class="layui-input">
                                    </td>
                                </tr>
                                <tr>
                                    <td>手机</td>
                                    <td><input type="text" name="phone" value="${user.phone}" class="layui-input"></td>
                                </tr>
                            </table>
                            <button class="layui-btn" lay-submit lay-filter="*">保存</button>
                        </form>
                    </div>
                </fieldset>
            </div>
        </div>

        <div class="layui-row">
            <div class="layui-col-md9">
                <fieldset class="layui-elem-field">
                    <legend>密码设置</legend>
                    <div class="layui-field-box">
                        <form action="" method="post" class="layui-form">
                            <input type="text" name="id" value="${user.id}" hidden>
                            <table class="layui-table">
                                <tr>
                                    <td>昵称</td>
                                    <td><input type="text" name="username" value="${user.username}" class="layui-input">
                                    </td>
                                </tr>
                                <tr>
                                    <td>请输入原来的密码</td>
                                    <td><input type="password" name="oldpassword" value="" class="layui-input"></td>
                                </tr>
                                <tr>
                                    <td>请输入新密码</td>
                                    <td><input type="password" name="password" value="" class="layui-input"></td>
                                </tr>
                                <tr>
                                    <td>确认密码</td>
                                    <td><input type="password" name="rpassword" value="" class="layui-input"></td>
                                </tr>
                            </table>
                            <button class="layui-btn" lay-submit lay-filter="*">保存</button>
                        </form>
                    </div>
                </fieldset>
            </div>

        </div>

    </div>
</div>
</body>
</html>

<script src="<%=request.getContextPath()%>/static/js/passport/myprofile.js"></script>