<%--
  Created by IntelliJ IDEA.
  User: huangwsa
  Date: 2017/2/16
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.ico" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.1.min.js"></script>

<link href="${pageContext.request.contextPath }/js/layui/layui/css/layui.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath }/js/layui/Font-Awesome/css/font-awesome.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/layui/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/layui/global.js"></script>

<link href="${pageContext.request.contextPath }/css/global.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath }/css/login.css" rel="stylesheet"/>

<script type="text/javascript">
    $(function () {
        if(window.parent != window){
            window.parent.location.reload(true);
        }
    });


</script>


<body>

<div class="layui-header header login-header">
    <div class="layui-main login-top-bg">
        <div class="sitename">
            <a class="logo" href="/">
                <img src="${pageContext.request.contextPath }/img/logo.png" alt="fhua"/>
            </a>
            <h2>购票系统</h2>
        </div>
    </div>
</div>
<div class="login_content">
    <div id="regist">
        <div id="login-banner">
            <a href="#" target="_blank">
                <img src="${pageContext.request.contextPath }/img/timg.jpg">
            </a>
        </div>
        <div id="login">
            <form action="/user/login" class="layui-form layui-form-pane" id="sign-in" method="post" role="form">
                <p>
                <div class="layui-form-item">
                    <label class="layui-form-label">账号</label>
                    <div class="layui-input-block">
                        <input name="username" id="txt_username" lay-verify="required" autocomplete="off"
                               placeholder="请输入账号" value="zhangsan" class="layui-input" type="text">
                    </div>
                </div>
                </p>
                <p>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input name="password" id="txt_password" lay-verify="required" autocomplete="off"
                               placeholder="请输入密码" value="111111" class="layui-input" type="password">
                    </div>
                </div>
                </p>
                <p class="submit">
                <div class="layui-form-item">
                    <a class="layui-btn" lay-submit="" data-loading-text="登录中..." lay-filter="btnsubmit">登　陆</a>
                </div>
                </p>
                <p id="nav">
                    忘记密码 or 没有账号？请与管理员联系。
                </p>
            </form>


        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="layui-footer footer footer-doc">
    <div class="layui-main">

        <p>COPYRIGHT &#169; 2017</p>

    </div>
</div>

<script type="text/javascript">
    layui.use(['layer', 'form', 'common'], function () {
        var $ = layui.jquery,
                layer = layui.layer,
                form = layui.form(),
                common = layui.common;

        //提交
        form.on('submit(btnsubmit)', function (formdata) {

            $("#sign-in").submit();
        });

        if("${sessionScope.loginErrMes}") {
            common.layerAlertE('登录失败：${sessionScope.loginErrMes}', '错误');
        }
    });
</script>
</body>
</html>
