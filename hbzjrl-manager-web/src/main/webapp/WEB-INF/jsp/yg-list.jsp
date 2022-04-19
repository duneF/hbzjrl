<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>张杰人力内部后台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="https://cdn.staticfile.org/jquery/3.6.0/jquery.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>
    <%--    <script src="/WEB-INF/css/login.css"></script>--%>



</head>
<body>
<jsp:include page="LoginOutDiv.jsp" flush="true"/>
<div class="table-responsive-sm row row-same-height">
    <table class="table  table-hover table-striped table-bordered text-nowrap col-sm " id="ygList" title="员工列表">
        <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th>ID</th>
            <th>渠道</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>身份证号</th>
            <th>手机</th>
            <th>出发日期</th>
            <th>住址</th>
            <th>企业</th>
            <th>合同日期</th>
            <th>发车</th>
            <th>发车补助</th>
            <th>员工单价</th>
            <th>员工备注</th>
            <th>代理</th>
            <th>代理单价</th>
            <th>代理备注</th>
            <th>总价</th>
            <%--            <th data-options="align:'center'">创建日期</th>--%>
            <%--            <th data-options="align:'center'">更新日期</th>--%>
        </tr>
        </thead>
        <tbody class="font-monospace ">
        <c:forEach items="${ygList}" var="l">
            <tr>
                <td><input type="checkbox" name="TiQuId" value="${l.user_id}"></td>
                <td>${l.user_id}</td>
                <td>${l.whereHome}</td>
                <td>${l.name}</td>
                <td>${l.age}</td>
                <td>${l.sex}</td>
                <td>${l.sfNumber}</td>
                <td>${l.phone}</td>
                <td><fmt:formatDate pattern="yyyy/MM/dd" value="${l.goTime}"/></td>
                <td>${l.address}</td>
                <td>${l.factory}</td>
                <td>${l.workTime}</td>
                <td>${l.byCar}</td>
                <td>${l.workerCarPrice}</td>
                <td>${l.workerPrice}</td>
                <td>${l.wokerRemarks}</td>
                <td>${l.whose}</td>
                <td>${l.whosePrice}</td>
                <td>${l.whoseRemarks}</td>
                <td>${l.totalPrice}</td>
                <td hidden="hidden"><fmt:formatDate pattern="yyyy/MM/dd" value="${l.createTime}"/></td>-
                <td hidden="hidden"><fmt:formatDate pattern="yyyy/MM/dd" value="${l.update}"/></td>
                <td>
                    <button type="button" class="btn btn-primary btn-sm"   data-bs-toggle="modal"
                            data-bs-target="#myModal" onclick="upDateCF(${l.user_id},'${l.whereHome}','${l.name}',
                            '${l.age}','${l.sex}','${l.sfNumber}','${l.phone}','${l.goTime}','${l.address}','${l.factory}',
                            '${l.workTime}','${l.byCar}','${l.workerCarPrice}','${l.workerPrice}','${l.wokerRemarks}',
                            '${l.whose}' ,'${l.whosePrice}','${l.whoseRemarks}','${l.totalPrice}','${l.createTime}' ,'${l.update}'
                            )" >
                        更改
                    </button>
                    <script>
                        $("#myModal").modal("hide");
                        function upDateCF(user_id,whereHome,name,age,sex,sfNumber,phone,goTime,address,factory,workTime,
                                          byCar,workerCarPrice,workerPrice,wokerRemarks,whose,whosePrice,whoseRemarks,totalPrice,
                                          createTime,update
                        ) {
                            $('#user_id').val(user_id);
                            $('#whereHome').val(whereHome);
                            $('#name').val(name);
                            $('#age').val(age);
                            $('#sex').val(sex);
                            $('#sfNumber').val(sfNumber);
                            $('#phone').val(phone);
                            $('#goTime').val(goTime);
                            $('#address').val(address);
                            $('#factory').val(factory);
                            $('#workTime').val(workTime);
                            $('#byCar').val(byCar);
                            $('#workerCarPrice').val(workerCarPrice);
                            $('#workerPrice').val(workerPrice);
                            $('#wokerRemarks').val(wokerRemarks);
                            $('#whose').val(whose);
                            $('#whosePrice').val(whosePrice);
                            $('#whoseRemarks').val(whoseRemarks);
                            $('#totalPrice').val(totalPrice);
                            $('#createTime').val(createTime);
                            $('#update').val(update);
                            /*  var xhttp = new XMLHttpRequest();
                              xhttp.open("POST", "/ygUpdateFindById?id="+user_id, true);
                              xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                              xhttp.send();
                              alert(user_id);*/
                        }
                    </script>

                    <form action="/ygUpdateFindById" method="post">
                        <div class="container mt-3">
                            <ul class="pagination pagination-lg justify-content-center" style="margin:1% 0">
                                <jsp:include page="UpdateTan.jsp"></jsp:include>
                            </ul>
                        </div>
                    </form>
                </td>
            </tr>
        </c:forEach>
        <tr style="height: 2px">
            <td colspan="22">
                <form form-horizontal action="/ygShowAll" method="post">
                    <div class="container mt-3">
                        <ul class="pagination pagination-lg justify-content-center" style="margin:1% 0">
                            <jsp:include page="/WEB-INF/page/pages2.jsp"></jsp:include>
                        </ul>
                    </div>
                </form>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<script>
    function goPage(pageNum) {
        $("[name='pageNum']").val(pageNum);
        $("form").submit();
    }
</script>

</body>
</html>