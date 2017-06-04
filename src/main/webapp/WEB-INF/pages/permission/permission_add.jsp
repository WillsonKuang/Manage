<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/27 0027
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../global/jsp/init.jsp" %>
<html>
<head>
    <title>添加权限</title>
</head>
<body>

<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>添加权限</h2>
    </blockquote>
    <form action="/permission/add" class="layui-form layui-form-pane" id="form_save" method="post" role="form">
        <div class="layui-form-item">
            <label class="layui-form-label">权限名称</label>
            <div class="layui-input-block">
                <input name="name" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">父级权限</label>
            <div class="layui-input-block">
                <input name="parentId" class="layui-input" type="password">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">URL</label>
            <div class="layui-input-block">
                <input name="url" class="layui-input" type="password">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">图标</label>
            <div class="layui-input-block">
                <select name="icon" class="layui-input">
                    <option value="">请选择一个图标</option>
                    <option value="fa fa-file-text"><i class="fa fa-file-text"></i></option>
                    <option value="fa fa-files-o"><i class="fa fa-files-o"></i></option>
                    <option value="fa-cut"><i class="fa fa-cut"></i></option>
                    <option value="fa-list-alt"><i class="fa fa-list-alt"></i></option>
                    <option value="fa-outdent"><i class="fa-outdent"></i></option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-block">
                <select name="type" class="layui-input">
                    <option value="">请选择一个图标</option>
                    <option value="0">菜单</option>
                    <option value="1">权限</option>
                </select>
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
<script>
    layui.use(['form'], function () {
        form = layui.form();
    });
</script>

</body>
</html>
