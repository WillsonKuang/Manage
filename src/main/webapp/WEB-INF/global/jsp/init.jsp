<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/19 0019
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>

<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.ico" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.1.min.js"></script>


<link href="${pageContext.request.contextPath }/js/layui-new/layui/css/layui.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/js/layui-new/fhuaui/css/fhuaui.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/js/layui-new/Font-Awesome/css/font-awesome.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath }/js/layui-new/layui/layui.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/myjs/global.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/myjs/_admin.js" type="text/javascript"></script>

<script type="text/javascript" >

    function doSearch() {

        $("#form_search").submit();

    }
    function doAdd(url) {
        location.href = url;
    }

    function doUpdate(url) {
        location.href = url;
    }
    function doRemove(url) {
        var checkboxs = $("[name=ids]:checked");

        if(checkboxs.length <= 0) {
            layer.alert('请至少选择一条记录进行删除！', {icon: 6});
            return false;
        }

        layer.confirm('确定要删除选中的记录吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            var ids = [];
            for (var i = 0; i < checkboxs.length; i++) {
                ids.push($(checkboxs[i]).prop("value"));
            }
            var _url = url + "?ids=" + ids.join(",");
            location.href = _url;

        }, function(){
        });
    }
    function doClear() {
        $("#form_search :input").not(":button, :submit, :reset, :hidden").val("").removeAttr("checked").remove("selected");
    }
    function goBack() {
        history.go(-1);
    }

    function doGoTo(url) {
        location.href = url;
    }

    function doSave() {
        $("#form_save").submit();
    }

    function changeNav(type) {
        $("#admin-navbar-side-" + type).css("display", "block");
        $("#admin-navbar-side-" + type).siblings("div").css("display", "none");
    }

</script>