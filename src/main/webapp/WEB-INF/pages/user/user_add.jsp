<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/27 0027
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../global/jsp/init.jsp" %>
<html>
<head>
    <title>用户添加</title>

</head>
<body>

<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>添加用户</h2>
    </blockquote>
    <form action="/user/add" class="layui-form layui-form-pane" id="form_save" method="post" role="form">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input name="username" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input name="password" class="layui-input" type="password">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">昵称</label>
            <div class="layui-input-block">
                <input name="nickname" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <input name="description" class="layui-input" type="text">
            </div>
        </div>

        <div class="btn-list">
            <div class="btnlist">
                <a class="layui-btn layui-btn-small" onclick="doSave();"><i class="fa fa-save"></i>提交</a>
                <a class="layui-btn layui-btn-small do-action" onclick="goBack();"><i class="fa fa-mail-reply"></i>返回上一页</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>
