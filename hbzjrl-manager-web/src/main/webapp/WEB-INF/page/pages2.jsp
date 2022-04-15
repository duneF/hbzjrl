<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="btn-group">

    <c:if test="${pg.total==0}">
        <i>暂无数据</i>
    </c:if>

    <c:if test="${pg.total!=0}">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="#" active>共 ${pg.total} 条信息</a>
            </li>
        </ul>
        <input type="number" name="pageSize" value="${pg.pageSize}" placeholder="每页显示" style="width: 88px">
        <button class="btn btn-outline-primary" type="submit">确定</button>
        &emsp;

        <button type="button" class="btn btn-outline-primary" onclick="goPage(1)">首页</button>
        <%--没有前面页数就隐藏--%>
        <c:if test="${pg.pageNum!=1}">
            <button type="button" class="btn btn-outline-primary" onclick="goPage(${pg.prePage==0?1:pg.prePage})">
                &laquo;&laquo;
            </button>
        </c:if>
        <%--List循环中间页面数--%>
        <c:forEach items="${pg.navigatepageNums}" var="n">
            <button type="button" class="btn btn-outline-primary" onclick="goPage(${n})">${n}</button>
        </c:forEach>
        <%--没有后面页数就隐藏--%>
        <c:if test="${pg.pageNum!=pg.pages}">
            <button type="button" class="btn btn-outline-primary"
                    onclick="goPage(${pg.nextPage==0?pg.pages:pg.nextPage})">
                &raquo;&raquo;
            </button>
        </c:if>
        <%--直达末页--%>
        <button type="button" class="btn btn-outline-primary" onclick="goPage(${pg.pages})">尾页</button>

        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="#">合计：${pg.pageNum}/${pg.pages}页</a>
            </li>
        </ul>

        <input type="number" name="pageNum" placeholder="跳转至..." style="width: 88px">

        <button class="btn btn-outline-primary" type="submit">跳转</button>
    </c:if>
</div>
