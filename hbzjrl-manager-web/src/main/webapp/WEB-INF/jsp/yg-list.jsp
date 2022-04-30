<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>张杰人力内部后台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/stvle.css">

    <link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="https://cdn.staticfile.org/jquery/3.6.0/jquery.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<nav class="menu-wrap">
    <div class="menu">
        <ul>
            <li>
                <a href="/ygShowAll" >
                    <i class="fa fa-home fa-lg"></i>
                    <span class="nav-text">首页</span>
                </a>
            </li>
            <li>
                <a href="">
                    <i class="fa fa-user fa-lg"></i>
                    <span class="nav-text">登录</span>
                </a>
            </li>
            <li>
                <a href=" ">
                    <i class="fa fa-envelope-o fa-lg"></i>
                    <span class="nav-text">联系</span>
                </a>
            </li>
            <li>
                <a href=" ">
                    <i class="fa fa-heart-o fa-lg"></i>
                    <span class="nav-text">收藏</span>
                </a>
            </li>
            <li>            </li>
            <li>            </li>
            <li>
                <span class="nav-text"><h1>共${pg.total}人</h1></span>
            </li>
            <%-- 吗不够再加li--%>
        </ul>
    </div>
</nav>

<header>
    <div class="px-3 py-2 border-bottom mb-3">
        <div class="container  d-flex flex-wrap justify-content-center">
            <div class="row">
                <form class="well form-search" action="/ygFindByQuDao">
                    <input name="whereHome"  type="search" class="input-medium search-query" placeholder="按渠道查询">
                    <button class="btn btn-primary" type="submit"><i class="icon-search"></i>渠道</button>
                </form>
            </div>
            <div class="row">
                <form class="well form-search" action="/ygFindByName" method="post">
                    <input name="name" type="search" class="input-medium search-query" placeholder="按姓名查询">
                    <button class="btn btn-primary" type="submit"><i class="icon-search"></i>姓名</button>
                </form>
            </div>
            <div class="text-end">
                <form class="well form-search" action="/ygFIndByPhone">
                    <input name="phoneToString" type="search" class="input-medium search-query" placeholder="按手机查询">
                    <button class="btn btn-primary" type="submit"><i class="icon-search"></i>手机</button>
                </form>
            </div>
            <div class="text-end">
                <form class="well form-search" action="ygFIndByAddress">
                    <input name="address" type="search" class="input-medium search-query" placeholder="按地址查询">
                    <button class="btn btn-primary" type="submit"><i class="icon-search"></i>地址</button>
                </form>
            </div>
            <div class="text-end">
                <form class="well form-search" action="ygFindByQiYe">
                    <input name="factory" type="search" class="input-medium search-query" placeholder="按企业查询">
                    <button class="btn btn-primary" type="submit"><i class="icon-search"></i>企业</button>
                </form>
            </div>
            &nbsp;<span style="float: right"><button onClick="window.location.href='/tiaoZhuanYgAddJsp'" class="btn btn-success">添加</button></span>
        </div>
    </div>

</header>
<div id="ygListDiv">
    <table class="table  table-hover table-striped table-bordered text-nowrap col-sm table-sm " id="ygList"
           title="员工列表">
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
            <%--<th data-options="align:'center'">创建日期</th>--%>
            <th data-options="align:'center'">更新日期</th>
        </tr>
        </thead>
        <tbody class="font-monospace ">
        <c:forEach items="${ygList}" var="l">
            <tr>
                <th><input type="checkbox" name="TiQuId" value="${l.user_id}"></th>
                <th>${l.user_id}</th>
                <th>${l.whereHome}</th>
                <th>${l.name}</th>
                <th>${l.age}</th>
                <th>${l.sex}</th>
                <th>${l.sfNumber}</th>
                <th>${l.phone}</th>
                <th><fmt:formatDate pattern="yyyy.MM.dd" value="${l.goTime}"/></th>
                <th>${l.address}</th>
                <th>${l.factory}</th>
                <th>${l.workTime}</th>
                <th>${l.byCar}</th>
                <th>${l.workerCarPrice}</th>
                <th>${l.workerPrice}</th>
                <th>${l.wokerRemarks}</th>
                <th>${l.whose}</th>
                <th>${l.whosePrice}</th>
                <th>${l.whoseRemarks}</th>
                <th>${l.totalPrice}</th>
                <th hidden="hidden"><fmt:formatDate pattern="yyyy.MM.dd" value="${l.createTime}"/></th>
                <th><fmt:formatDate pattern="yyyy.MM.dd" value="${l.update}"/></th>
                <th>
                    <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal"
                            data-bs-target="#myModal" onclick="upDateCF(${l.user_id},'${l.whereHome}','${l.name}',
                            '${l.age}','${l.sex}','${l.sfNumber}','${l.phone}','${l.goTime}','${l.address}','${l.factory}',
                            '${l.workTime}','${l.byCar}','${l.workerCarPrice}','${l.workerPrice}','${l.wokerRemarks}',
                            '${l.whose}' ,'${l.whosePrice}','${l.whoseRemarks}','${l.totalPrice}','${l.createTime}' ,'${l.update}'
                            )">
                        更改
                    </button>
                    <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal"
                            data-bs-target="#myModalDelById" onclick="delById(${l.user_id},'${l.name}')">
                        删除
                    </button>
                    <script>
                        $("#myModal").modal("hide");

                        function upDateCF(user_id, whereHome, name, age, sex, sfNumber, phone, goTime, address, factory, workTime,
                                          byCar, workerCarPrice, workerPrice, wokerRemarks, whose, whosePrice, whoseRemarks, totalPrice,
                                          createTime, update
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
                        }
                        $("#myModalDelById").modal("hide");
                        function delById(user_id,name) {
                            $('#user_id1').val(user_id);
                            $('#name2').val(name);
                        }
                    </script>
                    <form action="/deleteById" method="post">
                        <div class="container mt-3">
                            <ul class="pagination pagination-lg justify-content-center" style="margin:1% 0">
                                <jsp:include page="deleteById.jsp"></jsp:include>
                            </ul>
                        </div>
                    </form>
                    <form action="/ygUpdateIng" method="post">
                        <div class="container mt-3">
                            <ul class="pagination pagination-lg justify-content-center" style="margin:1% 0">
                                <jsp:include page="UpdateTan.jsp"></jsp:include>
                            </ul>
                        </div>
                    </form>
                </th>
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