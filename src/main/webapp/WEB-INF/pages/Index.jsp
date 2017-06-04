<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/18 0018
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../global/jsp/init.jsp"%>
<html>
<head>
    <title>后台管理主页面</title>
    <meta http-equiv="Content-Language" content="zh-cn" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta name="viewport" content="width=device-width, maximum-scale=1.0, initial-scale=1.0,initial-scale=1.0,user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
</head>

<script type="text/javascript">



</script>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header header header-admin">
        <div class="layui-main">
            <div class="fhuaui-logo">
                <a class="logo" href="/">
                    <img src="${pageContext.request.contextPath }/img/fhua/OPay.png" alt="FhuAdmin" />
                </a>
            </div>
            <button style="display: none" id="loadNan"></button>
            <ul class="layui-nav" id="menu">
                <li class="layui-nav-item" id="li_first">
                    <a href="javascript:;" data-type="1" onclick="changeNav('three');">
                        <i class="fa fa-send-o"></i>
                        <cite>三维系统</cite>
                    </a>
                </li>
                <li class="layui-nav-item" id="li_second">
                    <a href="javascript:;" data-type="2" onclick="changeNav('mng');">
                        <i class="fa fa-cog"></i>
                        <cite>管理系统</cite>
                    </a>
                </li>

            </ul>
            <div class="nav-user site-nav-layim">
                <a class="avatar" href="javascript:;">
                    <img src="${pageContext.request.contextPath }/img/fhua/91a56783a7056f2994023e5a81e63b28.png" />
                    <cite>${sessionScope.sessionUser.nickname}</cite>
                </a>
                <div class="nav">
                    <a href="javascript:;" class="open-tab" data-title="密码修改" data-href="" data-icon="fa fa-user-circle-o"><i class="fa fa-user-circle-o"></i>设置</a>
                    <a class="do-admin" data-type="doLoginOut" data-href="${pageContext.request.contextPath }/user/logout" data-rturl="${pageContext.request.contextPath }/index/toLogin"><i class="fa fa-sign-out"></i>退出</a>
                </div>
            </div>
        </div>
    </div>
    <div id="sidebar-side" class="layui-side layui-bg-black">

        <div id="admin-navbar-side-three" class="layui-side-scroll" lay-filter="side" >

        </div>

        <div id="admin-navbar-side-mng" class="layui-side-scroll" lay-filter="side" style="display: none">

        </div>
    </div>
    <div id="admin-body" class="layui-body" style="overflow:hidden;">
        <div class="layui-tab layui-tab-card admin-nav-card" lay-filter="admin-tab">
            <ul class="layui-tab-title" id="admin-tab">
                <li class="layui-this">
                    <i class="layui-icon" style="top: 2px; font-size: 16px;">&#xe609;</i>
                    <cite>主页</cite>
                </li>
            </ul>
            <div class="layui-tab-content" id="admin-tab-container" style="min-height:800px;height: auto; padding: 0px;overflow: hidden">
                <div class="layui-tab-item layui-show">
                    <iframe name="mainframe" frameborder="0" src="${pageContext.request.contextPath }/index/main"></iframe>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
