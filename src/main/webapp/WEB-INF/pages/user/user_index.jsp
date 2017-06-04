<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/26 0026
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@include file="../../global/jsp/init.jsp" %>
<html>
<head>
    <title>用户管理主页</title>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>用户管理</h2>
    </blockquote>
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <form id="form_search" type="post" action="/user/query" class="layui-form layui-form-pane">
            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                    <input type="text" name="username" class="layui-input" value="${requestScope.params.username}">
                </div>
                <label class="layui-form-label">昵称</label>
                <div class="layui-input-inline">
                    <input type="text" name="nickname" class="layui-input" value="${requestScope.params.nickname}">
                </div>
            </div>
        </form>
    </blockquote>
    <div class="y-role">
        <!--工具栏-->
        <div id="floatHead" class="toolbar-wrap">
            <div class="toolbar">
                <div class="box-wrap">
                    <a class="menu-btn"></a>
                    <div class="l-list">
                        <shiro:hasPermission name="user:add">
                            <a class="layui-btn layui-btn-small do-action" data-type="doAdd" data-href="javascript:void(0)" onclick="doAdd('/user/toAdd')"><i class="fa fa-plus"></i>新增</a>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="user:delete">
                            <a class="layui-btn layui-btn-small do-action" data-type="doDelete" data-href="javascript:void(0)" onclick="doRemove('/user/delete')"><i class="fa fa-trash-o"></i>删除</a>
                        </shiro:hasPermission>


                        <a class="layui-btn layui-btn-small do-action" data-type="doDelete" data-href="javascript:void(0)" onclick='doSearch();'><i class="fa fa-search"></i>搜索</a>
                        <a class="layui-btn layui-btn-small do-action" data-type="doDelete" data-href="javascript:void(0)" onclick="doClear();"></i>清空</a>
                    </div>
                </div>
            </div>
        </div>
        <!--/工具栏-->
        <!--文字列表-->
        <div class="fhui-admin-table-container">
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="5%">
                    <col width="10%">
                    <col width="10%">
                    <col width="50%">
                </colgroup>
                <thead>
                <tr>
                    <th>
                        <input type="checkbox" onclick="$('[name=ids]').prop('checked', this.checked)"/>
                    </th>
                    <th>用户名</th>
                    <th>昵称</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.pageBean.recordList}" var="bean">
                    <tr>
                        <td>
                            <input type="checkbox" value="${bean.id}" name="ids"/>
                        </td>
                        <td>
                                ${bean.username}
                        </td>
                        <td>
                                ${bean.nickname}
                        </td>
                        <td>
                            <shiro:hasPermission name="user:update">
                                <a class="layui-btn layui-btn-small do-action" data-href="javascript:void(0)" onclick="doUpdate('/user/toUpdate/${bean.id}')"><i class="icon-edit  fa fa-pencil-square-o"></i>编辑</a>
                            </shiro:hasPermission>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
            <div style="width: 100%; text-align: right">
                <%@include file="../../global/jsp/pageView.jsp" %>
            </div>
        </div>
    </div>
</div>


</body>
</html>
