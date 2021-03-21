# 校园闲置平台

校园闲置物品交易系统，为在校师生提供闲置物品发布、物品查询、物品交易等功能。
本项目有三个版本：
+ 纯HTML版本(html)
+ 使用PHP编写的(think)
+ 使用JAVA编写的(javaweb和ssm)


## Summary
  - [项目的技术栈](#项目的技术栈)
  - [项目功能介绍](#项目功能介绍)
  - [项目运行环境](#项目运行环境)
  - [部署项目](#部署项目)



## 项目的技术栈
+ IoC容器:Spring

+ web框架:SpringMVC
(PHP版为ThinkPHP)

+ orm框架:Mybatis

+ 安全框架:SpringSecurity

+ 数据源:Druid

+ 日志: SLF4J

+ Json: FastJson

+ 前端框架:LayUI

## 项目功能介绍

1) 进入系统之后可以通过搜索，个人中心功能来浏览别人的信息、还有发布自己的商品信息
![image](https://gitee.com/hhyygg/schooltrade/raw/master/images/search.png)
![image](https://gitee.com/hhyygg/schooltrade/raw/master/images/release.png)

2) 用户可以进行登录注册进入系统
![image](https://gitee.com/hhyygg/schooltrade/raw/master/images/my.png)


## 项目运行环境

环境搭建说明：
+ 开发环境为jdk11，基于maven构建；
+ 使用eclipase或Intellij Idea开发(推荐使用Intellij Idea)
+ 基于SpringBoot搭建，大大简化了配置操作。
+ 本项目使用了lombok,在查看本项目时如果您没有下载lombok 插件，请先安装,不然找不到get/set方法；

运行环境
>Java版
+ apache-tomcat-9.0.38
+ mysql-5.7.32-winx64

>PHP版
+ php-7.2.34-Win32-VC15-x64


## 部署项目
1. 配置环境、初始化项目

    1) 下载Mysql,创建一个数据库名字为schooltrade,导入sql即可
    
    2) 下载Tomcat

2. 配置开发环境     
    1) 使用IDE导入项目,之后配置项目启动方式,使用刚才下载好的Tomcat


2. 权限介绍：
1) 管理员，默认账户为admin,密码为admin

