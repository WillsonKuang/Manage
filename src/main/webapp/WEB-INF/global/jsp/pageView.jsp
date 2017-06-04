<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<div id=PageSelectorMemo>
    <span style="font-size: 16px">
        页次:${requestScope.pageBean.currentPage}/${requestScope.pageBean.pageCount}页 &nbsp;
        每页显示:${requestScope.pageBean.pageSize }条 &nbsp;
        总记录数:${requestScope.pageBean.recordCount }条&nbsp;
    </span>

    <div class="layui-laypage">
        <a class="" href="javascript: gotoPage(1)">首页</a>
        <c:choose>
            <c:when test="${requestScope.pageBean.currentPage == 1}">
                <a class="" href="javascript: void(0)">上一页</a>
            </c:when>
            <c:when test="${requestScope.pageBean.currentPage != 1}">
                <a class="" href="javascript: gotoPage(${requestScope.pageBean.currentPage - 1})">上一页</a>
            </c:when>
        </c:choose>
        <c:forEach begin="${requestScope.pageBean.beginPageIndex}" end="${requestScope.pageBean.endPageIndex}"
                   var="num">
            <a class="" href="javascript: gotoPage(${num})"
                    <c:if test="${requestScope.pageBean.currentPage == num}">
                        style="background-color: #1AA094"
                    </c:if>
            >${num}</a>
        </c:forEach>
        <c:choose>
            <c:when test="${requestScope.pageBean.currentPage == requestScope.pageBean.pageCount}">
                <a class="" href="javascript: void(0)">下一页</a>
            </c:when>
            <c:when test="${requestScope.pageBean.currentPage != requestScope.pageBean.pageCount}">
                <a class="" href="javascript: gotoPage(${requestScope.pageBean.currentPage + 1})">下一页</a>
            </c:when>
        </c:choose>
        <a href="javascript: gotoPage(${requestScope.pageBean.pageCount})">尾页</a>
    </div>
    <span style="font-size: 16px">
         &nbsp;&nbsp;转到:
    <select id="pn" onchange="gotoPage(this.value)" style="width: 60px">
        <c:forEach end="${requestScope.pageBean.pageCount}" begin="1" var="num">
            <option value="${num}">${num}</option>
        </c:forEach>
    </select>
    </span>

    <script type="text/javascript">
        // 回显页码
        $("#pn").val("${requestScope.pageBean.currentPage}");
    </script>

</div>

<script type="text/javascript">
    function gotoPage(pageNum) {
        $("#form_search").append("<input type='hidden' name='pageNum' value='" + pageNum + "'/>");
        $("#form_search").submit(); // 提交表单
    }
</script>