<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div>
    管理
    <zidingyi style="font-weight: 900; color: lime">${userDengLu}</zidingyi>
    在线
<%--  <input type="button" value="退出登陆" onclick="location.href='${pageContext.request.contextPath }/loginOut'"/>--%>
    <input type="button" value="退出登陆" onclick="location.href=${pageContext.request.contextPath}/loginOut"/>
</div>