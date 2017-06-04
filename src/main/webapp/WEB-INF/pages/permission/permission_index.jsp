<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/27 0027
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@include file="../../global/jsp/init.jsp" %>
<html>
<head>
    <title>权限管理主页</title>
</head>
<body>
<div class="main-wrap">
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <h2>权限管理</h2>
    </blockquote>
    <blockquote class="layui-elem-quote fhui-admin-main_hd">
        <form id="form_search" type="post" action="/permission/query" class="layui-form layui-form-pane">
            <div class="layui-form-item">
                <label class="layui-form-label">权限名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" class="layui-input" value="${requestScope.params.name}">
                </div>
                <label class="layui-form-label">URL</label>
                <div class="layui-input-inline">
                    <input type="text" name="url" class="layui-input" value="${requestScope.params.url}">
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
                        <shiro:hasPermission name="permission:add">
                            <a class="layui-btn layui-btn-small do-action" data-type="doAdd" data-href="javascript:void(0)" onclick="doAdd('/permission/toAdd')"><i class="fa fa-plus"></i>新增</a>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="permission:delete">
                            <a class="layui-btn layui-btn-small do-action" data-type="doDelete" data-href="javascript:void(0)" onclick="doRemove('/permission/delete')"><i class="fa fa-trash-o"></i>删除</a>
                        </shiro:hasPermission>


                        <a class="layui-btn layui-btn-small do-action" data-type="doDelete" data-href="javascript:void(0)" onclick='doSearch();'><i class="fa fa-search"></i>搜索</a>
                        <a class="layui-btn layui-btn-small do-action" data-type="doDelete" data-href="javascript:void(0)" onclick="doClear();"><i class="fa fa-trash-o"></i>清空</a>
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
                    <col width="15%">
                    <col width="15%">
                    <col width="5%">
                    <col width="10%">
                    <col width="20%">
                    <col width="30%">
                </colgroup>
                <thead>
                <tr>
                    <th>
                        <input type="checkbox" onclick="$('[name=ids]').prop('checked', this.checked)"/>
                    </th>
                    <th>权限名称</th>
                    <th>父权限</th>
                    <th>图标</th>
                    <th>URL</th>
                    <th>描述信息</th>
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
                                ${bean.name}
                        </td>
                        <td>
                                ${bean.parentName}
                        </td>
                        <td>
                            <i class="${bean.icon}"></i>
                        </td>
                        <td>
                                ${bean.url}
                        </td>
                        <td>
                                ${bean.description}
                        </td>
                        <td>
                            <shiro:hasPermission name="permission:update">
                                <a class="layui-btn layui-btn-small do-action" data-href="javascript:void(0)" onclick="doUpdate('/permission/toUpdate/${bean.id}')"><i class="icon-edit  fa fa-pencil-square-o"></i>编辑</a>
                            </shiro:hasPermission>
                            <shiro:hasPermission name="permission:update">
                                <a class="layui-btn layui-btn-small do-action" data-href="javascript:void(0)" onclick="doGoTo('/permission/toAddChild/${bean.id}')"><i class="icon-edit  fa fa-pencil-square-o"></i>添加子权限</a>
                            </shiro:hasPermission>
                            <shiro:hasPermission name="permission:delete">
                                <a class="layui-btn layui-btn-small do-action" data-href="javascript:void(0)" onclick="doRemove('/permission/delete/${bean.id}')"><i class="icon-edit  fa fa-pencil-square-o"></i>删除</a>
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
